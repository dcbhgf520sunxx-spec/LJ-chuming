import { e2 as p } from "../shared/runtime.js";
import { g as u, a as l, b as g } from "./payment-settlement-e8e799d8.js";
import { ref as c } from "vue";
function v({ form: e = {} }) {
  const i = c([]), o = c([]), s = c([]), n = c([]);
  return { projectAllInfoData: i, projectList: o, supplierList: s, contractNoList: n, getProjectList: async (t) => {
    try {
      const r = await u(e.projectManagerId);
      i.value = r, r ? o.value = r.map((a) => a.project) : (p("warning", "该项目经理下暂无项目"), o.value = []);
    } catch (r) {
      console.log(r);
    }
  }, getSupplierList: async () => {
    if (e.projectManagerId && e.projectId) try {
      const t = await l({ projectId: e.projectId, projectManagerId: e.projectManagerId });
      if (!t) {
        p("warning", "该项目下暂无供应商"), s.value = [];
        return;
      }
      s.value = Object.entries(t).map(([r, a]) => ({ id: r, value: a }));
    } catch (t) {
      console.error("获取供应商失败:", t);
    }
  }, getContractNo: async () => {
    if (e.projectManagerId && e.projectId && e.supplierId) try {
      const t = await g({ projectId: e.projectId, projectManagerId: e.projectManagerId, supplierId: e.supplierId });
      t && Object.keys(t).length ? n.value = Object.entries(t).map(([r, a]) => ({ id: r, value: a })).sort((r, a) => Number(a.id) - Number(r.id)) : (p("warning", "该项目下暂无合同号"), n.value = []);
    } catch (t) {
      console.log(t);
    }
  } };
}
export {
  v as u
};
