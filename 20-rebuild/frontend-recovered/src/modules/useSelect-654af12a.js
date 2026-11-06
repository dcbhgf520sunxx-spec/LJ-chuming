import { iS as p, iT as u, iU as g, iV as L } from "../shared/runtime.js";
import { ref as o } from "vue";
import { onMounted as y } from "vue";
function w() {
  const a = o([]), c = async () => {
    try {
      a.value = await p();
    } catch (t) {
      console.log(t);
    }
  }, r = o([]), n = async () => {
    try {
      const { content: t } = await u();
      r.value = t.map((e) => ({ ...e, projectNames: e.serialNumber + " - " + e.shortName }));
    } catch (t) {
      console.log(t);
    }
  }, s = o([]), i = async () => {
    try {
      const { content: t } = await g();
      s.value = t;
    } catch (t) {
      console.log(t);
    }
  }, l = async () => {
    try {
      const { content: t } = await L();
      return t;
    } catch (t) {
      console.log("获取税率列表失败", t);
    }
  };
  return y(async () => {
    await n(), await c(), await i();
  }), { projectLeaderList: a, allProjectList: r, supplierList: s, getTaxRateList: l };
}
export {
  w as u
};
