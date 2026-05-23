package org.domiot.mapper;

import org.domiot.entities.SiteEntity;
import org.domiot.model.Site;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {UserMapper.class})
public interface SiteMapper {

    Site map(SiteEntity siteEntity);

    @Mapping(target = "id", ignore = true)
    SiteEntity map(Site site);

    List<Site> map(List<SiteEntity> siteEntities);

    List<SiteEntity> mapToEntities(List<Site> sites);

}
