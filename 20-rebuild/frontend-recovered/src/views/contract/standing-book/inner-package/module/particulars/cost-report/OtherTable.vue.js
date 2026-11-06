import { inject as m } from "vue";
import { ref as u } from "vue";
import { watch as b } from "vue";
import { resolveComponent as h } from "vue";
import { openBlock as g } from "vue";
import { createElementBlock as f } from "vue";
import { renderSlot as x } from "vue";
import { createVNode as t } from "vue";
import { withCtx as v } from "vue";
import { unref as n } from "vue";
import { ElTableColumn as w } from "element-plus";
import { b as y } from "../../../../../../../modules/cost-report-60aee68e.js";
import { _ as T, o as j, eb as B } from "../../../../../../../shared/runtime.js";
import { u as O } from "../../../../../../../modules/useTableTotal-3d22365a.js";
const C = { class: "managementFee-table" }, D = { __name: "OtherTable", setup(q) {
  const p = m("parent_data"), { projectInfo: r } = p, l = u([]), { requestData: s, total: c } = O(), { maxHeight: _ } = j({ extraBox: [".el-button-group", ".report-container", ".el-radio-group", ".header-container"], mainBox: [".app-container", ".drawer-container"], wrapperBox: [], paginate: true }), o = async () => {
    try {
      const { content: e, totalElements: i } = await y({ ...s, projectId: r.project.id });
      l.value = e, c.value = i;
    } catch (e) {
      console.log("获取其他费用明细失败" + e);
    }
  };
  return o(), b(() => r, (e) => {
    e.project.id && o();
  }, { deep: true }), (e, i) => {
    const a = w, d = h("common-table");
    return g(), f("div", C, [x(e.$slots, "default", {}, void 0, true), t(d, { data: l.value, "max-height": n(_), border: "", fit: "", "show-summary": "" }, { default: v(() => [t(a, { align: "center", label: "序号", type: "index", width: "60" }), t(a, { align: "center", label: "日期" }), t(a, { align: "center", label: "事项" }), t(a, { align: "center", label: "金额" }), t(a, { align: "center", label: "填报人" })]), _: 1 }, 8, ["data", "max-height"]), t(B, { "request-data": n(s), total: n(c), onHandleChange: o }, null, 8, ["request-data", "total"])]);
  };
} }, M = T(D, [["__scopeId", "data-v-c7e35e90"]]);
export {
  M as default
};
