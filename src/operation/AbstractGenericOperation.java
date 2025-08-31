/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation;

import repository.DBRepository;
import repository.Repository;
import repository.db.impl.RepositoryDBGeneric;

/**
 *
 * @author user
 */
public abstract class AbstractGenericOperation {

    protected final Repository repository;

    public AbstractGenericOperation() {
        this.repository = new RepositoryDBGeneric();
    }

    public final void execute(Object param) throws Exception {
        try {
            preconditions(param);
            startTransaction();
            executeOperation(param);
            commitTransaction();
        } catch (Exception ex) {
            rollbackTransaction();
            throw ex;
        } finally {
            disconnect();
        }
    }

    protected abstract void preconditions(Object param) throws Exception;

    private void startTransaction() throws Exception {
        ((DBRepository) repository).connect();
    }

    protected abstract void executeOperation(Object param) throws Exception;

    protected void commitTransaction() throws Exception {
        ((DBRepository) repository).commit();
    }

    protected void rollbackTransaction() throws Exception {
        ((DBRepository) repository).rollback();
    }

    private void disconnect() throws Exception {
        ((DBRepository) repository).disconnect();
    }

}
