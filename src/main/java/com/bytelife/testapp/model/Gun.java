package com.bytelife.testapp.model;

import java.io.Serializable;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.annotations.Type;

/**
 *
 * @author Dmitri Maksimov
 */
@Entity
public class Gun implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Type(type = "uuid-char")
  private UUID id;

  @NotNull
  @Size(min = 4, max = 16)
  private String name;
  @NotNull
  private GunType type;
  @NotNull
  private Double caliber;
  @Min(100)
  @Max(10000)
  private Integer weigth;
  @Size(max = 32)
  private String country;

  @ManyToOne
  private GunRack gunRack;

  public Gun() {
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

  public GunType getType() {
    return type;
  }

  public void setType(GunType type) {
    this.type = type;
  }

  public Double getCaliber() {
    return caliber;
  }

  public void setCaliber(Double caliber) {
    this.caliber = caliber;
  }

  public Integer getWeigth() {
    return weigth;
  }

  public void setWeigth(Integer weigth) {
    this.weigth = weigth;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
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
    if (!(object instanceof Gun)) {
      return false;
    }
    Gun other = (Gun) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "com.bytelife.testapp.model.Gun[ id=" + id + " ]";
  }

}
