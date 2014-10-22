package com.bytelife.testapp.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.Type;

/**
 *
 * @author Dmitri Maksimov
 */
@Entity
public class GunRack implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Type(type = "uuid-char")
  private UUID id;

  @NotNull
  private String name;

  @NotNull
  @Min(1)
  @Max(10)
  private Integer capacity;

  @OneToMany(mappedBy = "gunRack")
  private List<Gun> guns;

  public GunRack() {
    this.id = UUID.randomUUID();
  }

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getCapacity() {
    return capacity;
  }

  public void setCapacity(Integer capacity) {
    this.capacity = capacity;
  }

  public List<Gun> getGuns() {
    if (guns == null) {
      guns = new ArrayList<>();
    }
    return guns;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (id != null ? id.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof GunRack)) {
      return false;
    }
    GunRack other = (GunRack) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "com.bytelife.testapp.model.GunRack[ id=" + id + " ]";
  }

}
