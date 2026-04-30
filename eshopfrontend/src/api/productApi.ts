import axiosInstance from '../axios/axios';

const productApi = {
    findAll: async () => {
        return await axiosInstance.get('/products');
    }
};

export default productApi;
