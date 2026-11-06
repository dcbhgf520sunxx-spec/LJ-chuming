import { inject as c } from "vue";
import { ref as I } from "vue";
import { watch as i } from "vue";
import { resolveComponent as y } from "vue";
import { withDirectives as T } from "vue";
import { vShow as f } from "vue";
import { unref as e } from "vue";
import { openBlock as v } from "vue";
import { createElementBlock as E } from "vue";
import { createVNode as m } from "vue";
import { a3 as n, B as b, bZ as j } from "../../../../../../shared/runtime.js";
const g = { __name: "header", setup(C) {
  const d = c("projectId"), s = { monomerId: void 0, areaId: void 0, taskTypeEnum: n.ARTIFACT.V }, { crud: t, query: o, CRUD: u } = b(s), l = I([n.ARTIFACT, n.ASSEMBLE]);
  return u.HOOK.beforeToQuery = () => {
    t.query.projectId = d.value;
  }, i([() => o.monomerId, () => o.areaId, () => d.value], () => {
    t.toQuery();
  }), (k, a) => {
    const p = y("common-radio-button");
    return T((v(), E("div", null, [m(p, { modelValue: e(o).taskTypeEnum, "onUpdate:modelValue": a[0] || (a[0] = (r) => e(o).taskTypeEnum = r), options: l.value, type: "enum", default: "", class: "filter-item", onChange: e(t).toQuery }, null, 8, ["modelValue", "options", "onChange"]), m(e(j), { monomerId: e(o).monomerId, "onUpdate:monomerId": a[1] || (a[1] = (r) => e(o).monomerId = r), areaId: e(o).areaId, "onUpdate:areaId": a[2] || (a[2] = (r) => e(o).areaId = r), productType: e(o).taskTypeEnum, "project-id": e(o).projectId, clearable: "", areaClearable: "" }, null, 8, ["monomerId", "areaId", "productType", "project-id"])], 512)), [[f, e(t).searchToggle]]);
  };
} };
export {
  g as default
};
