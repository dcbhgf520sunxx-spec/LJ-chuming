import { b as l, d as u, e as g } from "./index-69cea220.js";
import { e2 as p } from "../shared/runtime.js";
import { ref as a } from "vue";
function M({ form: e = {} }) {
  const i = a([]), c = a([]), o = a([]), s = a([]);
  return { projectAllInfoData: i, projectList: c, supplierList: o, contractNoList: s, getProjectList: async (t) => {
    try {
      const r = await l(e.projectManagerId);
      i.value = r, r ? c.value = r.map((n) => n.project) : (p("warning", "该项目经理下暂无项目"), c.value = []);
    } catch (r) {
      console.log(r);
    }
  }, getSupplierList: async () => {
    if (e.projectId && e.projectManagerId) try {
      const t = await u({ projectId: e.projectId, projectManagerId: e.projectManagerId });
      if (!t) {
        p("warning", "该项目下暂无供应商"), o.value = [];
        return;
      }
      o.value = t.map((r) => ({ id: r.supplierId, value: r.supplierName }));
    } catch (t) {
      console.error("获取供应商失败:", t);
    }
  }, getContractNo: async () => {
    if (e.projectManagerId && e.projectId && e.supplierId) try {
      const t = await g({ projectId: e.projectId, projectManagerId: e.projectManagerId, supplierId: e.supplierId });
      t && Object.keys(t).length ? s.value = Object.entries(t).map(([r, n]) => ({ id: r, value: n })) : (p("warning", "该项目下暂无合同号"), s.value = []);
    } catch (t) {
      console.log(t);
    }
  } };
}
export {
  M as u
};
