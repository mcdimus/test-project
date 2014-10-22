package com.bytelife.testapp.jsf_classes;

import com.bytelife.testapp.jsf_classes.util.JsfUtil;
import com.bytelife.testapp.model.GunRack;
import com.bytelife.testapp.session_bean.GunRackFacade;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author Dmitri Maksimov
 */
@Named
@ViewScoped
public class GunRackController implements Serializable {

  @EJB
  private GunRackFacade gunRackFacade;

  private List<GunRack> gunRacks;

  public void init() {
    this.gunRacks = gunRackFacade.findAll();
  }

  public List<GunRack> getGunRacks() {
    return gunRacks;
  }

  public void delete(GunRack gunRack) {
    gunRackFacade.remove(gunRack);
    init();
    JsfUtil.addSuccessMessage("GunRack '" + gunRack.getName() + "' has been successfully deleted.");
  }

}
