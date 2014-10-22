package com.bytelife.testapp.session_bean;

import com.bytelife.testapp.model.GunRack;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Dmitri Maksimov
 */
@Stateless
public class GunRackFacade extends AbstractFacade<GunRack> {

  @PersistenceContext
  private EntityManager em;

  @Override
  protected EntityManager getEntityManager() {
    return em;
  }

  public GunRackFacade() {
    super(GunRack.class);
  }

  @Override
  public List<GunRack> findAll() {
    List<GunRack> findAll = super.findAll();
    findAll.forEach((GunRack x) -> x.getGuns().size());
    return findAll; //To change body of generated methods, choose Tools | Templates.
  }

}
