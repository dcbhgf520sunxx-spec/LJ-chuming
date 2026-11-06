import { ref as g } from "vue";
import { computed as u } from "vue";
import { inject as T } from "vue";
import { watchEffect as w } from "vue";
import { openBlock as y } from "vue";
import { createBlock as S } from "vue";
import { ElCascader as L } from "element-plus";
import { g as b } from "../../../../../../../../modules/project-production-statistics-850038ba.js";
import { i, b as l } from "../../../../../../../../shared/runtime.js";
const B = { __name: "workshop-cascader", props: { workshopId: { type: [Number, String], default: void 0 }, productionLineId: { type: [Number, String], default: void 0 }, teamId: { type: [Number, String], default: void 0 }, productType: { type: [Number, String] }, isTeamId: { type: Boolean, default: false } }, emits: ["update:workshopId", "update:productionLineId", "update:teamId", "change"], setup(c, { emit: m }) {
  const t = c, n = m, p = g([]), s = u({ get() {
    return t.isTeamId ? [t.workshopId, t.productionLineId, t.teamId].filter((e) => i(e)) : [t.workshopId, t.productionLineId].filter((e) => i(e));
  }, set(e) {
    (e === null || l(e)) && (e = []), n("update:workshopId", e[0]), n("update:productionLineId", e[1]), t.isTeamId && n("update:teamId", e[2]);
  } }), d = T("projectId"), f = u(() => ({ value: "id", label: "name", children: "children", expandTrigger: "hover", checkStrictly: true })), h = (e, o) => e.projectProductionLineDTOS.map((r) => ({ ...r, children: o.isTeamId ? I(r) : null })), I = (e) => e.projectTeamDTOS.map((o) => ({ ...o, name: o.userName + "-" + o.processName })), k = async (e, o) => {
    const { content: r } = await b(e);
    p.value = r.map((a) => ({ ...a, children: h(a, o) }));
  };
  return w(async () => {
    if (console.log("workshop"), l(d.value)) return;
    const e = { projectId: d.value, productType: t.productType };
    s.value = [], p.value = [], k(e, t);
  }), (e, o) => {
    const r = L;
    return y(), S(r, { class: "filter-item", modelValue: s.value, "onUpdate:modelValue": o[0] || (o[0] = (a) => s.value = a), options: p.value, props: f.value, filterable: "", clearable: "", "show-all-levels": true, placeholder: t.isTeamId ? "请选择车间/生产线/班组" : "请选择车间/生产线", style: { width: "200px" }, onChange: o[1] || (o[1] = () => e.$emit("change")) }, null, 8, ["modelValue", "options", "props", "placeholder"]);
  };
} };
export {
  B as default
};
