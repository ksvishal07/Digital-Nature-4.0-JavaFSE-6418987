import React from 'react';

const App = () => {
  const heading = <h1>Office Space Rental Listings</h1>;

  const officeList = [
    {
      id: 1,
      name: 'Skyline Towers',
      rent: 55000,
      address: '100 Main Street, Bangalore',
      image: 'https://png.pngtree.com/background/20230604/original/pngtree-modern-corporate-business-office-background-wallpaper-picture-image_2873050.jpg'
    },
    {
      id: 2,
      name: 'Downtown Hub',
      rent: 75000,
      address: '200 Tech Park Road, Chennai',
      image: 'https://images.pexels.com/photos/1170412/pexels-photo-1170412.jpeg?cs=srgb&dl=people-office-inside-1170412.jpg&fm=jpg'
    },
    {
      id: 3,
      name: 'EcoSpace',
      rent: 60000,
      address: '500 Green Ave, Hyderabad',
      image: 'https://as1.ftcdn.net/v2/jpg/04/17/41/14/1000_F_417411465_QCAPDf1cs1U50EqnR90QexEcHuXCKKda.jpg'
    }
  ];

  return (
    <div style={{ padding: '20px', fontFamily: 'Arial' }}>
      {heading}

      {officeList.map((office) => (
        <div key={office.id} style={{ marginBottom: '20px', border: '1px solid #ccc', padding: '10px' }}>
          <img src={office.image} alt={office.name} style={{ width: '300px', height: '200px' }} />
          <h2>{office.name}</h2>
          <p><strong>Address:</strong> {office.address}</p>
          <p>
            <strong>Rent:</strong>{' '}
            <span style={{ color: office.rent > 60000 ? 'green' : 'red' }}>
              ₹{office.rent}
            </span>
          </p>
        </div>
      ))}
    </div>
  );
};

export default App;
