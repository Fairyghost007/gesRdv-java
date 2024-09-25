// package org.example.data.core.factory;

// import org.example.data.repositories.db.ClientRepositoryDb;
// import org.example.data.repositories.db.ClientRepositoryDbImpl;
// import org.example.data.repositories.db.UserRepositoryDbImpl;
// import org.example.data.repositories.db.UserRepositoryDb;
// import org.example.data.repositories.list.ClientRepository;

// public class Factory {
//     private Factory() {
        
//     }   
//     private static ClientRepositoryDbImpl clientRepositoryDbImpl;
//     private static UserRepositoryDbImpl userRepositoryDbImpl;

//     public static ClientRepositoryDbImpl getInstanceClientRepository(){
//         if(clientRepositoryDbImpl == null){
//             clientRepositoryDbImpl = new ClientRepositoryDbImpl();
//         }
//         return clientRepositoryDbImpl;
//     } 

//     public static UserRepositoryDbImpl getInstanceUserRepository(){
//         if(userRepositoryDbImpl == null){
//             userRepositoryDbImpl = new UserRepositoryDbImpl();
//         }
//         return userRepositoryDbImpl;
//     }
// }
