package fr.treeptik.dao.impl;

import java.io.Serializable;

import javax.ejb.Stateless;

import fr.treeptik.dao.MissionDAO;
import fr.treeptik.model.Mission;

@Stateless
public class MissionDAOImpl extends GenericDAOImpl<Mission, Integer> implements MissionDAO,
		Serializable {

	private static final long serialVersionUID = 1L;

	public MissionDAOImpl() {
		super(Mission.class);
	}

	// @Inject
	// private Logger log;
	//
	// @Inject
	// private EntityManager em;

	// @Override
	// public void register(Mission mission) throws DAOException {
	// log.info("Registering " + mission.getNom());
	// // em.persist(mission);
	// em.merge(mission);
	// }
	//
	// @Override
	// public void remove(Mission mission) throws DAOException {
	// log.info("Removing " + mission.getNom());
	// em.remove(mission);
	// }
	//
	// @Override
	// public List<Mission> findAll() throws DAOException {
	// try {
	// return em.createQuery("SELECT mis FROM Mission mis", Mission.class).getResultList();
	// } catch (PersistenceException e) {
	// throw new DAOException(e.getMessage(), e.getCause());
	// }
	// }
	//
	// @Override
	// public void removeById(Integer id) throws DAOException {
	// try {
	// Query query = em.createQuery("DELETE FROM Mission mis WHERE mis.id = :id");
	// query.setParameter("id", id);
	// query.executeUpdate();
	// } catch (PersistenceException e) {
	// throw new DAOException(e.getMessage(), e.getCause());
	// }
	//
	// }
	//
	// @Override
	// public Mission findById(Integer id) throws DAOException {
	// try {
	// return em.find(Mission.class, id);
	// } catch (PersistenceException e) {
	// throw new DAOException(e.getMessage(), e.getCause());
	// }
	// }

}
