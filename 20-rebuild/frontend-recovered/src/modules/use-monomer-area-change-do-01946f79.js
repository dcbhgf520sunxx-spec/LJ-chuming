import { f as l, h as s } from "./project-production-statistics-850038ba.js";
import { G as a, pQ as c } from "../shared/runtime.js";
import { ref as r } from "vue";
const n = r({}), i = r([]), o = r(false), g = () => ({ projectProductionTotal: n, projectProductionDetail: i, getProjectProductionHttp: async (e) => {
  if (a(c.getTotal)) try {
    o.value = true;
    const t = await l(e);
    n.value = t;
  } catch (t) {
    console.log(t);
  } finally {
    o.value = false;
  }
}, getProjectProductionDetailHttp: async (e) => {
  if (a(c.getTotal)) try {
    o.value = true;
    const t = await s(e);
    i.value = t;
  } catch (t) {
    console.log(t);
  } finally {
    o.value = false;
  }
}, loading: o });
export {
  g as u
};
