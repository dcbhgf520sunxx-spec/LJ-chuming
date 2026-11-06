import { bo as r, bZ as u } from "../../../../../../shared/runtime.js";
import { u as g } from "../../../../../../modules/use-monomer-area-change-do-01946f79.js";
import { inject as h } from "vue";
import { ref as I } from "vue";
import { resolveComponent as f } from "vue";
import { openBlock as C } from "vue";
import { createElementBlock as y } from "vue";
import { createVNode as m } from "vue";
import { unref as o } from "vue";
import "../../../../../../modules/project-production-statistics-850038ba.js";
const _ = { class: "head-container" }, S = { __name: "header", setup(b) {
  const e = h("commonQuery"), s = I([r.NET, r.GROSS]), { getProjectProductionHttp: l, getProjectProductionDetailHttp: c } = g(), n = () => {
    l(e), c(e);
  }, d = () => {
    n();
  }, p = () => {
    n();
  };
  return (j, t) => {
    const i = f("common-select");
    return C(), y("div", _, [m(i, { modelValue: o(e).weightType, "onUpdate:modelValue": t[0] || (t[0] = (a) => o(e).weightType = a), options: s.value, type: "enum", class: "filter-item", clearable: false, style: { width: "200px" }, placeholder: "请选择重量类型", onChange: p }, null, 8, ["modelValue", "options"]), m(o(u), { monomerId: o(e).monomerId, "onUpdate:monomerId": t[1] || (t[1] = (a) => o(e).monomerId = a), areaId: o(e).areaIdList, "onUpdate:areaId": t[2] || (t[2] = (a) => o(e).areaIdList = a), clearable: "", areaClearable: "", areaMultiple: "", "project-id": o(e).projectId, onMonomerChange: n, onAreaChange: d }, null, 8, ["monomerId", "areaId", "project-id"])]);
  };
} };
export {
  S as default
};
