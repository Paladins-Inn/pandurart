/*
 * Copyright (c) 2025. Roland T. Lichti, Kaiserpfalz EDV-Service
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package de.paladinsinn.pandurart.persistence.locations;

import de.paladinsinn.pandurart.domain.api.locations.PhysicalAddress;
import de.paladinsinn.pandurart.domain.api.locations.WebLocation;
import de.paladinsinn.pandurart.domain.model.locations.PhysicalAddressImpl;
import de.paladinsinn.pandurart.domain.model.locations.WebLocationImpl;
import de.paladinsinn.pandurart.persistence.events.JpaEvent;
import de.paladinsinn.pandurart.persistence.mapper.DisplayTextMapper;
import de.paladinsinn.pandurart.persistence.mapper.OwnerMapper;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(
    componentModel = "spring",
    uses = {
        OwnerMapper.class,
        DisplayTextMapper.class
    }
)
public interface LocationMapper {
  PhysicalAddressImpl toPhysicalAddress(JpaPhysicalAddress entity);
  @Mapping(target = "id", source = "domain.id")
  @Mapping(target = "version", source = "domain.version")
  @Mapping(target = "owner", source = "domain.owner")
  @Mapping(target = "name", source = "domain")
  @Mapping(target = "event", expression = "java(event)")
  JpaPhysicalAddress toJpaPhysicalAddress(PhysicalAddress domain, @Context JpaEvent event);
  
  WebLocationImpl toWebLocation(JpaWebLocation entity);
  @Mapping(target = "id", source = "domain.id")
  @Mapping(target = "version", source = "domain.version")
  @Mapping(target = "owner", source = "domain.owner")
  @Mapping(target = "name", source = "domain")
  @Mapping(target = "event", expression = "java(event)")
  JpaWebLocation toJpaWebLocation(WebLocation domain, @Context JpaEvent event);
}