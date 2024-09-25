package org.example.data.core.factory;

import org.example.data.repositories.db.MedecinRepositoryDbImpl;
import org.example.data.repositories.db.RvRepositoryDbImpl;

public class RepositoryFactory {

    private static MedecinRepositoryDbImpl medecinRepositoryDbImpl=null;
    private static RvRepositoryDbImpl rvRepositoryDbImpl=null;
    public static MedecinRepositoryDbImpl createMedecinRepository() {
        if(medecinRepositoryDbImpl == null){
            medecinRepositoryDbImpl = new MedecinRepositoryDbImpl();
        }
        return medecinRepositoryDbImpl;
    }

    public static RvRepositoryDbImpl createRvRepository() {
        if(rvRepositoryDbImpl == null){
            rvRepositoryDbImpl = new RvRepositoryDbImpl();
        }
        return rvRepositoryDbImpl;
    }
}
