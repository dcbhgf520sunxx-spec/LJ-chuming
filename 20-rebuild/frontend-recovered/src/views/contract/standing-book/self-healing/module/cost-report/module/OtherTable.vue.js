import { inject as b } from "vue";
import { ref as d } from "vue";
import { watchEffect as h } from "vue";
import { watch as _ } from "vue";
import { resolveComponent as g } from "vue";
import { openBlock as v } from "vue";
import { createElementBlock as w } from "vue";
import { createVNode as a } from "vue";
import { withCtx as y } from "vue";
import { unref as s } from "vue";
import { ElTableColumn as x } from "element-plus";
import { j1 as j, ec as C } from "../../../../../../../shared/runtime.js";
import { u as T } from "../../../../../../../modules/useTableHeight-90797a0b.js";
import { u as D } from "../../../../../../../modules/useTableTotal-3d22365a.js";
const S = { class: "managementFee-table" }, O = { __name: "OtherTable", emits: ["updateSum"], setup(k, { emit: m }) {
  const c = m, { projectInfo: r } = b("tableItem"), o = d([]), { maxHeight: i, tableRef: u } = T(), { getSummaries: p, _sums: n } = D(false, { defineData: ["reimburseAmount"] }), l = async () => {
    try {
      const e = await j.get(`/api/project/v2/selfSupportCost/${r.value.project.id}`);
      e.length || (o.value = []), o.value = C(e);
    } catch (e) {
      console.log("获取其他费用明细失败" + e);
    }
  };
  return l(), h(() => {
    n && c("updateSum", n.value[5]);
  }), _(() => r.value, (e) => {
    e.project.id && l();
  }, { deep: true }), (e, E) => {
    const t = x, f = g("common-table");
    return v(), w("div", S, [a(f, { ref_key: "tableRef", ref: u, data: o.value, "max-height": s(i), stripe: "", "summary-method": s(p), border: "", "show-summary": "" }, { default: y(() => [a(t, { align: "center", label: "序号", type: "index", width: "60" }), a(t, { align: "center", label: "日期", prop: "date" }), a(t, { align: "center", label: "填报人", prop: "informant.name" }), a(t, { align: "center", label: "报销人", prop: "reimburseUser.name" }), a(t, { align: "center", label: "摘要", prop: "summary", "min-width": "150" }), a(t, { align: "center", label: "金额", prop: "reimburseAmount" })]), _: 1 }, 8, ["data", "max-height", "summary-method"])]);
  };
} };
export {
  O as default
};
