package com.cg.creditcardbillpayment.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.creditcardbillpayment.dao.StatementRepository;
import com.cg.creditcardbillpayment.entities.Statement;
import com.cg.creditcardbillpayment.exceptions.DuplicateStatementException;
import com.cg.creditcardbillpayment.exceptions.NoSuchStatementException;


/*********************************************************************************************************************************
 * @author           K.Hima Susmitha 
 * Description       It is a service class that provides the
 *                   services to add a statement,remove a Statement,update a Statement and view Statement
 * Version           1.0 
 * Created Date      24-03-2021
 *********************************************************************************************************************************/
@Service
public class StatementServiceImpl implements IStatementService {

	@Autowired
	private StatementRepository statementRepository;

	/******************************************************************************************************************************
	 * Method                                   : addStatment
     * Description                              : To add statements to the database
	 * @param statement                         - statement to be added to the Database
	 * @returns Statement                       - returns newStatement
	 * @throws DuplicateStatementException      - It is raised when statement already exits in the Database
     * Created By                               - K.Hima Susmitha
     * Created Date                             - 23-03-2021                           
     ************************************************************************************************************************/
	@Override
	public Statement addStatement(Statement statement) throws DuplicateStatementException {
		// TODO Auto-generated method stub

		Optional<Statement> resultStatement = statementRepository.findById(statement.getStatementId());
		if (resultStatement.isEmpty()) {
			return statementRepository.saveAndFlush(statement);
		} else {
			throw new DuplicateStatementException("Statement already exits");
		}

	}
	
	
	
	
	/*******************************************************************************************************************************
	 * Method                                   : removeStatment
     * Description                              : To remove statements from database
	 * @param id                                - statement id to be deleted
	 * @returns String                          - returns response message when statement removed
	 * @throws NoSuchStatementException        	- It is raised when id does not exits in the Database
     * Created By                               - K.Hima Susmitha
     * Created Date                             - 23-03-2021                           
	 ********************************************************************************************************************************/
	@Override
	public String removeStatement(long id) throws NoSuchStatementException {
		// TODO Auto-generated method stub
		Optional<Statement> statement = statementRepository.findById(id);
		if (statement.isEmpty())
			throw new NoSuchStatementException("Statement " + id + " does not exits");
		else
			statementRepository.delete(statement.get());
		return "Statement deleted successfully";

	}
	
	
	/*********************************************************************************************************************************
	 * Method                                   : updateStatment
     * Description                              : To update statements to the database
	 * @param id                                - To check the statement is present in the database
	 * @param statement                         - statement to be updated to the Database
	 * @returns Statement                       - returns updated statement
	 * @throws NoSuchStatementException         - It is raised when statement was not found in the Database
     * Created By                               - K.Hima Susmitha
     * Created Date                             - 23-03-2021                           
	 **********************************************************************************************************************************/
	@Override
	public Statement updateStatement(long id, Statement statement) throws NoSuchStatementException {
		// TODO Auto-generated method stub
		Optional<Statement> resultStatement = statementRepository.findById(id);
		if (resultStatement.isEmpty()) {
			throw new NoSuchStatementException("Statement "+id+" not found");
		}
		statementRepository.save(statement);
		return statement;
	}
	
	
	
	
	/**********************************************************************************************************************************
	 * Method                                   : getStatment
     * Description                              : To fetch the statements from the database
	 * @param id                                - id of the statement to be fetched
	 * @returns Statement                       - returns statement
	 * @throws NoSuchStatementException         - It is raised when the id does not exit in the Database
     * Created By                               - K.Hima Susmitha
     * Created Date                             - 23-03-2021                           
	 ***********************************************************************************************************************************/
	@Override
	public Statement getStatement(long id) throws NoSuchStatementException {
		// TODO Auto-generated method stub
		Optional<Statement> statement = statementRepository.findById(id);
		if (statement.isEmpty()) {
			throw new NoSuchStatementException("Statement "+id+" does not exit");
		}
		return statement.get();
	}
	
	
	
	
	/************************************************************************************************************************************
	 * Method                                   : getAllStatments
     * Description                              : To fetch all the statements from the database
	 * @returns List<Statement>                 - returns all statements
	 * @throws NoSuchStatementException         - It is raised when the statements were not found in Database
     * Created By                               - K.Hima Susmitha
     * Created Date                             - 23-03-2021                           
	 *************************************************************************************************************************************/

	@Override
	public List<Statement> getAllStatements() throws NoSuchStatementException {
		// TODO Auto-generated method stub
		List<Statement> statements = statementRepository.findAll();
		if (statements.isEmpty()) {
			throw new NoSuchStatementException("No Statements found ");
		}
		return statements;
	}
	

	/*************************************************************************************************************************************
	 * Method                                   : getBilledStatement
     * Description                              : To fetch the BilledStatements from the database
	 * @returns  List<Statement>                - returns all BilledStatements
     * Created By                               - K.Hima Susmitha
     * Created Date                             - 23-03-2021                           
	 *************************************************************************************************************************************/
	
	@Override
	public List<Statement> getBilledStatement() {
		// TODO Auto-generated method stub
		return statementRepository.getBilledStatement();
	}
	
	
	
	/*************************************************************************************************************************************
	 * Method                                  : getUnbilledStatement
     * Description                             : To fetch the UnbilledStatements from the database
	 * @returns List<Statement>                - returns all UnbilledStatements
     * Created By                              - K.Hima Susmitha
     * Created Date                            - 23-03-2021                           
	 **************************************************************************************************************************************/
	@Override
	public List<Statement> getUnbilledStatement() {
		// TODO Auto-generated method stub
		return statementRepository.getUnBilledStatement();
	}
	

	/**********************************************************************************************************************************
	 * Method                                   : getStatementByCardId
     * Description                              : To fetch the statement from the database
	 * @param cardId                            - id of the card to fetch statement
	 * @returns Statement                       - returns statement
	 * @throws NoSuchStatementException         - It is raised when the id does not exit in the Database
     * Created By                               - K.Hima Susmitha
     * Created Date                             - 23-03-2021                           
	 ***********************************************************************************************************************************/



	@Override
	public Statement getStatementByCardId(long cardId) throws NoSuchStatementException {
		// TODO Auto-generated method stub
		Optional<Statement> statement = statementRepository.findCardById(cardId);
		if(statement.isEmpty()) {
			throw new NoSuchStatementException("No Statement found ");
		}
		return statement.get();
	}

}
