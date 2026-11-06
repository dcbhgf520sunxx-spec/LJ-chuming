import { computed as d } from "vue";
import { ref as T } from "vue";
import { inject as k } from "vue";
import { watchEffect as w } from "vue";
import { openBlock as g } from "vue";
import { createBlock as L } from "vue";
import { ElCascader as y } from "element-plus";
import { g as v } from "../../../../../../../modules/project-production-statistics-850038ba.js";
import { i as c, b as i } from "../../../../../../../shared/runtime.js";
const B = { __name: "workshop-cascader", props: ["workshopId", "productionLineId", "teamId", "productType", "isTeamId"], emits: ["update:workshopId", "update:productionLineId", "update:teamId", "change"], setup(u, { emit: l }) {
  const r = u, a = l, n = d({ get() {
    return r.isTeamId ? [r.workshopId, r.productionLineId, r.teamId].filter((e) => c(e)) : [r.workshopId, r.productionLineId].filter((e) => c(e));
  }, set(e) {
    (e === null || i(e)) && (e = []), a("update:workshopId", e[0]), a("update:productionLineId", e[1]), r.isTeamId && a("update:teamId", e[2]);
  } }), s = T([]), p = k("commonQuery"), m = d(() => ({ value: "id", label: "name", children: "children", expandTrigger: "hover", checkStrictly: true }));
  w(async () => {
    const e = { ...p, productType: r.productType };
    if (i(p.projectId)) return;
    n.value = [], s.value = [];
    const { content: o } = await v(e);
    s.value = o.map((t) => ({ ...t, children: h(t) }));
  });
  const h = (e) => e.projectProductionLineDTOS.map((o) => ({ ...o, children: r.isTeamId ? I(o) : null })), I = (e) => e.projectTeamDTOS.map((o) => ({ ...o, name: o.userName + "-" + o.processName }));
  return (e, o) => {
    const t = y;
    return g(), L(t, { class: "filter-item", modelValue: n.value, "onUpdate:modelValue": o[0] || (o[0] = (f) => n.value = f), options: s.value, props: m.value, filterable: "", clearable: "", "show-all-levels": true, placeholder: r.isTeamId ? "请选择车间/生产线/班组" : "请选择车间/生产线", style: { width: "200px" }, onChange: o[1] || (o[1] = () => e.$emit("change")) }, null, 8, ["modelValue", "options", "props", "placeholder"]);
  };
} };
export {
  B as default
};
