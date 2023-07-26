import React, { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import Button from "../button/Button";

const CommonTable = () => {
  const [serviceRequestData, setServiceRequestData] = useState([]);

  const tableDataHandler = async () => {
    const data ={}
    setServiceRequestData([...data]);
  };
  useEffect(() => {
    tableDataHandler();
  }, []);
  console.log(serviceRequestData);
  return (
    <div>
      <table className="table table-hover">
        <thead>
          <tr>
            <th>Id</th>
            <th>Name</th>
          </tr>
        </thead>
        <tbody>
          {serviceRequestData.map((val) => {
            return (
              <tr key={val.id}>
                <td>
                  <Button className={"btn btn-success"} name={"View"} />
                  
                  
                </td>
              </tr>
            );
          })}
        </tbody>
      </table>
    </div>
  );
};

export default CommonTable;
