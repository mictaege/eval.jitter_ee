package com.github.mictaege.eval.jitteree;

import javax.ejb.Local;
import java.util.List;

@Local
public interface DaoIF {

    List<Bearer> findBearers();
}
