import React, { useState } from "react";
import AuthAccess from "../DataAccess/AuthAccess";
import { Link, useNavigate } from "react-router-dom";

function TrainersRegistration() {
    const [trainersRegistrationData, setTrainersRegistrationData] = useState({ });
    const navigate = useNavigate();
    const trainersRegistration = (e) => {
      let name = e.target.name;
      let value = e.target.value;
      setTrainersRegistrationData(
        (prevState) => ({
          ...prevState,
          [name]: value,
        }),
        []
      );
    };
  
    const trainersRegistrationHandeler = async  (e) => {
      e.preventDefault();
        const trainersRegistrationResponse = {};
      
    };
  return (
    <div className="col-md-12 d-flex align-items-center justify-content-center">
      <div className="card">
        <form className="" onSubmit={(e) => trainersRegistrationHandeler(e)}>
          <div className="card-body">
            <h3 className="">Trainers Registration</h3>

            <div className="form-group mt-3">
              <label>Email address</label>
              <input
                type="text"
                name="fullName"
                className="form-control mt-1"
                placeholder="Full Name"
                onChange={(e) => trainersRegistration(e)}
              />
            </div>
            <div className="form-group mt-3">
              <label>Profile Picture</label>
              <input
                type="file"
                name="profilePicture"
                className="form-control mt-1"
                placeholder="Profile Picture"
                onChange={(e) => trainersRegistration(e)}
              />
            </div>
            <div className="form-group mt-3">
              <label>Designation</label>
              <input
                type="text"
                name="designation"
                className="form-control mt-1"
                placeholder="Designation"
                onChange={(e) => trainersRegistration(e)}
              />
            </div>
            
            <div className="form-group mt-3">
              <label>Joining Date</label>
              <input
                type="date"
                name="joiningDate"
                className="form-control mt-1"
                placeholder="Joining Date"
                onChange={(e) => trainersRegistration(e)}
              />
            </div>
            <div className="form-group mt-3">
              <label>Total years of experience</label>
              <input
                type="number"
                name="totalYearsOfExperience"
                className="form-control mt-1"
                placeholder="Total years of experience"
                onChange={(e) => trainersRegistration(e)}
              />
            </div>
            
            <div className="form-group mt-3">
              <label>Expertises</label>
              <input
                type="text"
                name="expertises"
                className="form-control mt-1"
                placeholder="Expertises"
                onChange={(e) => trainersRegistration(e)}
              />
            </div>
            
            <div className="form-group mt-3">
              <label>Contact number</label>
              <input
                type="text"
                name="ContactNumber"
                className="form-control mt-1"
                placeholder="Contact number"
                onChange={(e) => trainersRegistration(e)}
              />
            </div>
            
            <div className="form-group mt-3">
              <label>Present Adrress</label>
              <input
                type="text"
                name="presentAdrress"
                className="form-control mt-1"
                placeholder="Present Adrress"
                onChange={(e) => trainersRegistration(e)}
              />
            </div>
            <div className="d-grid gap-2 mt-3">
              <button type="submit" className="btn btn-primary">
                Submit
              </button>
            </div>
          </div>
        </form>
      </div>
    </div>
  )
}

export default TrainersRegistration