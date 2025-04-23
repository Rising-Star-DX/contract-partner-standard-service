package com.partner.contract.standard.repository;

import com.partner.contract.common.enums.AiStatus;
import com.partner.contract.standard.domain.Standard;
import com.partner.contract.standard.dto.StandardContentResponseDto;
import com.partner.contract.standard.dto.StandardCountsResponseDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
//public interface StandardRepository extends JpaRepository<Standard, Long>, StandardRepositoryCustom {
public interface StandardRepository extends JpaRepository<Standard, Long> {
    @Query("select s from Standard s where s.aiStatus is not null and s.name like %:name% order by s.createdAt desc")
    List<Standard> findByNameContainingOrderByCreatedAtDesc(@Param("name") String name);

    @Query("select s from Standard s where s.aiStatus is not null and s.name like %:name% and s.categoryId = :categoryId order by s.createdAt desc")
    List<Standard> findStandardListOrderByCreatedAtDesc(@Param("name") String name, @Param("categoryId") Long categoryId);

//    @Query("select s from Standard s join fetch s.category c where s.id = :id")
//    Optional<Standard> findWithCategoryById(@Param("id") Long id);

    List<Standard> findByAiStatusAndCreatedAtBefore(AiStatus aiStatus, LocalDateTime fiveMinutesAgo);

    Boolean existsByCategoryIdAndAiStatus(Long categoryId, AiStatus aiStatus);

    @Query("""
        select new com.partner.contract.standard.dto.StandardContentResponseDto(
            sc.id, sc.page, sc.content
        )
        from StandardContent sc
        where sc.standard.id = :id
""")
    List<StandardContentResponseDto> findstandardContentResponseByStandardId(@Param("id") Long id);

    Boolean existsByCategoryId(Long categoryId);

    @Query("select new com.partner.contract.standard.dto.StandardCountsResponseDto(s.categoryId, count(s.categoryId)) from Standard s group by s.categoryId")
    List<StandardCountsResponseDto> countByCategoryId();
}
