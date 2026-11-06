import { ref as r } from "vue";
import { onMounted as N } from "vue";
import { provide as g } from "vue";
import { resolveComponent as v } from "vue";
import { openBlock as w } from "vue";
import { createElementBlock as j } from "vue";
import { createVNode as t } from "vue";
import { withDirectives as B } from "vue";
import { unref as n } from "vue";
import { createBlock as L } from "vue";
import { withCtx as s } from "vue";
import { createElementVNode as U } from "vue";
import { toDisplayString as h } from "vue";
import { createTextVNode as A } from "vue";
import { ElTableColumn as H } from "element-plus";
import { ElTag as I } from "element-plus";
import { vLoading as M } from "element-plus";
import P from "./module/header.vue.js";
import { x as S, o as $, tD as F, m9 as _, P as O, mb as Q } from "../../../../shared/runtime.js";
import W from "./module/approval/index.vue.js";
import { c as q } from "./module/approval/enclosure/index.vue.js";
import z from "./module/approval/structure/index.vue.js";
import { B as d } from "../../../../modules/plan-d12d7ccf.js";
import "./module/approval/enclosure/module/header.vue.js";
import "../../../../modules/area-audit-list-39a1a7c7.js";
import "../../../../modules/use-drawing-8a7ba23b.js";
import "../../../../modules/bim-preview-drawer-7ca7893b.js";
import "../../../../modules/bim-model-view-dbf77a11.js";
import "../../../../modules/bimfaceAPI-c2661893.js";
import "../../../../modules/model-0ac957f7.js";
import "../../../../modules/index-d6a37d29.js";
import "../../../../modules/drawing-preview-fullscreen-dialog-60155503.js";
import "../../../../modules/use-chart-59e4b63c.js";
import "../../../../modules/index-18acf776.js";
const K = { class: "app-container" }, fe = { __name: "index", setup(G) {
  const b = r(), m = r(), f = r([]), p = r(false), c = r(false), { crud: l, CRUD: y } = S({ title: "清单审核", crudApi: { ...q }, permission: d }, b), { maxHeight: x } = $({ paginate: true }), T = r([["createTime", ["parse-time"]], ["reviewedTime", ["parse-time"]], ["buildingType", ["parse-enum", F]]]);
  function V(o) {
    o && (m.value = o, console.log(o), o.buildingType === "围护制品" ? p.value = true : c.value = true);
  }
  async function C() {
    try {
      const { content: o } = await Q();
      f.value = o || [];
    } catch (o) {
      console.log(o);
    }
  }
  return N(() => {
    C();
  }), y.HOOK.handleRefresh = async (o, { data: i }) => {
    i.content = i.content.map((e) => (e.projectName = e.projectInfo.name, e.monomerName = e.monomer.name, e.areaName = e.area.name, e));
  }, g("currentRow", m), g("enclosureDictList", f), (o, i) => {
    const e = H, R = I, k = v("common-button"), D = v("common-table"), E = M;
    return w(), j("div", K, [t(P), B((w(), L(D, { data: n(l).data, "data-format": T.value, "empty-text": n(l).emptyText, "max-height": n(x), "return-source-data": true }, { default: s(() => [t(e, { align: "center", label: "序号", type: "index", width: "60" }), t(e, { align: "left", label: "项目编号", "min-width": "120", prop: "projectInfo.serialNumber", "show-overflow-tooltip": "" }), t(e, { align: "left", label: "项目", "min-width": "160", prop: "projectInfo.name", "show-overflow-tooltip": "" }), t(e, { align: "center", label: "类型", prop: "buildingType", "show-overflow-tooltip": "", width: "120" }), t(e, { align: "left", label: "单体", "min-width": "160", prop: "monomer.name", "show-overflow-tooltip": "" }), t(e, { align: "left", label: "区域", "min-width": "160", prop: "area.name", "show-overflow-tooltip": "" }), t(e, { align: "center", label: "单位", prop: "unit" }), t(e, { align: "center", label: "重量", "min-width": "120", prop: "totalWeight", "show-overflow-tooltip": "" }, { default: s(({ row: a }) => [U("span", null, h(a.totalWeight.toFixed(2)), 1)]), _: 1 }), t(e, { align: "center", label: "创建人", prop: "createUserName", width: "140" }), t(e, { align: "center", label: "日期", prop: "createTime", width: "140" }), t(e, { align: "center", label: "审核人", "min-width": "120", prop: "reviewedName" }), t(e, { align: "center", label: "审核日期", "min-width": "140", prop: "reviewedTime" }), t(e, { align: "center", fixed: "right", label: "状态", prop: "inventoryReviewedEnum", width: "100" }, { default: s(({ row: a }) => {
      var u;
      return [t(R, { type: (u = n(_).V[a.inventoryReviewedEnum]) == null ? void 0 : u.T }, { default: s(() => [A(h(n(_).VL[a.inventoryReviewedEnum]), 1)]), _: 2 }, 1032, ["type"])];
    }), _: 1 }), t(e, { align: "center", fixed: "right", label: "操作", width: "80" }, { default: s(({ row: a }) => [t(k, { icon: "el-icon-view", size: "default", type: "primary", onClick: (u) => V(a) }, null, 8, ["onClick"])]), _: 1 })]), _: 1 }, 8, ["data", "data-format", "empty-text", "max-height"])), [[E, n(l).loading]]), t(O), t(W, { key: "enclosure", modelValue: p.value, "onUpdate:modelValue": i[0] || (i[0] = (a) => p.value = a), permission: n(d), onClose: n(l).toQuery }, null, 8, ["modelValue", "permission", "onClose"]), t(z, { key: "structure", modelValue: c.value, "onUpdate:modelValue": i[1] || (i[1] = (a) => c.value = a), "current-row": m.value, permission: n(d), onSuccess: n(l).toQuery }, null, 8, ["modelValue", "current-row", "permission", "onSuccess"])]);
  };
} };
export {
  fe as default
};
