package com.cg.creditcardbillpayment.services;

import java.util.List;

import com.cg.creditcardbillpayment.entities.Statement;
import com.cg.creditcardbillpayment.exceptions.DuplicateStatementException;
import com.cg.creditcardbillpayment.exceptions.NoSuchStatementException;

public interface IStatementService {
	
	public Statement addStatement(Statement statement)throws DuplicateStatementException ;
	public String removeStatement(long id) throws NoSuchStatementException;
	public Statement updateStatement(long id, Statement statement) throws NoSuchStatementException;
	public Statement getStatement(long id) throws NoSuchStatementException;
	public List<Statement> getAllStatements() throws NoSuchStatementException;
	public List<Statement> getBilledStatement();
	public List<Statement> getUnbilledStatement();
	
	public Statement getStatementByCardId(long cardId)throws NoSuchStatementException;
}
