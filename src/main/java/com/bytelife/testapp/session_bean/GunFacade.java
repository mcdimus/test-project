package com.bytelife.testapp.session_bean;

import com.bytelife.testapp.model.Gun;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Dmitri Maksimov
 */
@Stateless
public class GunFacade extends AbstractFacade<Gun> {

  @PersistenceContext
  private EntityManager em;

  @Override
  protected EntityManager getEntityManager() {
    return em;
  }

  public GunFacade() {
    super(Gun.class);
  }

}
