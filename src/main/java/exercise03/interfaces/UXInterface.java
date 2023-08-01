package exercise03.interfaces;

import exercise03.models.Element;
import exercise03.models.Repository;

public interface UXInterface {
  void showMenu();

  void showMenuRepository(Repository<Element> repository, String typeRepository);
}
