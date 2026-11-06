import { ref as m } from "vue";
import { resolveComponent as k } from "vue";
import { openBlock as l } from "vue";
import { createElementBlock as B } from "vue";
import { createElementVNode as h } from "vue";
import { createVNode as p } from "vue";
import { unref as t } from "vue";
import { withDirectives as R } from "vue";
import { createBlock as o } from "vue";
import { withCtx as i } from "vue";
import { createTextVNode as f } from "vue";
import { toDisplayString as s } from "vue";
import { createCommentVNode as u } from "vue";
import { ElTableColumn as U } from "element-plus";
import { vLoading as A } from "element-plus";
import { c as E } from "../../../../modules/scheduling-2b0c95c3.js";
import { e as H } from "../../../../modules/project-data-5e9d497a.js";
import { x as T, o as O, lX as $, G as S, P as q } from "../../../../shared/runtime.js";
import z from "./module/header.vue.js";
import G from "./template/steel-plate-list.vue.js";
import K from "../../template/detail.vue.js";
import { d as x } from "../../../../modules/cutting-457c256f.js";
import "../../../../modules/factory-select-b8d0a4ac.js";
import "./template/detail.vue.js";
const X = { class: "app-container" }, F = { class: "head-container" }, se = { __name: "index", setup(J) {
  const b = m(), v = m(false), _ = m(false), w = m();
  m([]), m(false), m(), m(false);
  const L = { add: false, edit: false, del: false, download: false }, { crud: y, CRUD: V, columns: c } = T({ title: "设备任务", sort: [], permission: { ...x }, optShow: { ...L }, crudApi: { ...E }, hasPagination: true }, b);
  V.HOOK.handleRefresh = (d, r) => {
    r.data.content = r.data.content.map((e, g) => (e.subList = [], e.rowIndex = g, e));
  };
  async function W(d, r) {
    console.log(d, r), d.loadingList = true;
    try {
      const e = await H.get({ nestingState: d.nestingState, sort: ["id.desc"], projectId: d.projectId, mac: d.cutMachine.mac });
      console.log("data", e), d.subList = e.content;
    } catch {
      console.log("请求接口数据失败");
    }
    d.loadingList = false;
  }
  const { maxHeight: N } = O({ wrapperBox: ".contractRecord", paginate: true, extraHeight: 40 }), C = m(false);
  async function D(d) {
    w.value = d, v.value = true;
  }
  function M(d) {
    w.value = d, _.value = true;
  }
  return (d, r) => {
    const e = U, g = k("common-button"), j = k("common-table"), P = k("task-schedul"), I = A;
    return l(), B("div", X, [h("div", F, [p(t(z))]), R((l(), o(j, { ref_key: "tableRef", ref: b, data: t(y).data, "empty-text": t(y).emptyText, "max-height": t(N) - 50, style: { width: "100%" }, "row-key": "cutMachine.id", onExpandChange: W, returnSourceData: "" }, { default: i(() => [p(e, { type: "expand" }, { default: i((a) => [R((l(), o(j, { ref_key: "tableRef", ref: b, data: a.row.subList, "max-height": t(N), "row-key": "id", style: { width: "100%" }, border: "" }, { default: i(() => [p(e, { prop: "index", label: "序号", align: "center", width: "60", type: "index" }), t(c).visible("cutInstructionId") ? (l(), o(e, { "header-align": "center", key: "cutInstructionId", prop: "cutInstructionId", "show-overflow-tooltip": true, style: { width: "100%" }, label: "切割指令号", align: "center", "min-width": "80" }, { default: i((n) => [f(s(n.row.cutInstructionId), 1)]), _: 2 }, 1024)) : u("", true), t(c).visible("thick") ? (l(), o(e, { "header-align": "center", key: "thick", prop: "thick", "show-overflow-tooltip": true, style: { width: "100%" }, label: "钢板厚度", align: "center", "min-width": "60" }, { default: i((n) => [f(s(n.row.thick), 1)]), _: 2 }, 1024)) : u("", true), t(c).visible("material") ? (l(), o(e, { "header-align": "center", key: "material", prop: "material", "show-overflow-tooltip": true, style: { width: "100%" }, label: "材质", align: "center", "min-width": "60" }, { default: i((n) => [f(s(n.row.material), 1)]), _: 2 }, 1024)) : u("", true), t(c).visible("specification") ? (l(), o(e, { "header-align": "center", key: "specification", prop: "specification", "show-overflow-tooltip": true, style: { width: "100%" }, label: "规格", align: "center", "min-width": "60" }, { default: i((n) => [f(s(n.row.width) + " * " + s(n.row.length), 1)]), _: 2 }, 1024)) : u("", true), t(c).visible("num") ? (l(), o(e, { "header-align": "center", key: "num", prop: "num", "show-overflow-tooltip": true, style: { width: "100%" }, label: "数量", align: "center", "min-width": "60" }, { default: i(() => r[3] || (r[3] = [h("span", null, "1", -1)])), _: 1, __: [3] })) : u("", true), t(c).visible("plateState") ? (l(), o(e, { align: "center", key: "plateState", prop: "plateState", label: "完成状态", "min-width": "100px" }, { default: i((n) => [f(s(t($).VL[n.row.plateState]), 1)]), _: 2 }, 1024)) : u("", true), t(c).visible("projectName") ? (l(), o(e, { key: "projectName", prop: "projectName", "show-overflow-tooltip": true, label: "所属项目", "header-align": "center", "min-width": "130px" }, { default: i((n) => [h("span", null, s(n.row.projectNumber) + "-" + s(n.row.projectName), 1)]), _: 2 }, 1024)) : u("", true), t(S)(t(x).detailResult) ? (l(), o(e, { key: 7, align: "center", label: "查看套料成果", "min-width": "40" }, { default: i((n) => [p(g, { type: "success", size: "default", onClick: (Q) => M(n.row) }, { default: i(() => r[4] || (r[4] = [f("查看")])), _: 2, __: [4] }, 1032, ["onClick"])]), _: 2 }, 1024)) : u("", true)]), _: 2 }, 1032, ["data", "max-height"])), [[I, a.row.loadingList]])]), _: 1 }), p(e, { prop: "index", label: "序号", align: "center", width: "60", type: "index" }), t(c).visible("projectName") ? (l(), o(e, { key: "projectName", prop: "projectName", "show-overflow-tooltip": true, label: "产线名称", "header-align": "center", "min-width": "130px" }, { default: i((a) => [h("span", null, s(a.row.cutMachine.factory) + ">" + s(a.row.cutMachine.workshopInf) + ">" + s(a.row.cutMachine.productionLine), 1)]), _: 1 })) : u("", true), t(c).visible("plateNum") ? (l(), o(e, { align: "center", key: "plateNum", prop: "plateNum", label: "任务张数", "min-width": "100px" }, { default: i((a) => [h("span", null, s(a.row.plateNum), 1)]), _: 1 })) : u("", true), t(c).visible("plateWeight") ? (l(), o(e, { align: "center", key: "plateWeight", prop: "plateWeight", label: "任务重", "min-width": "100px" }, { default: i((a) => [h("span", null, s(a.row.plateWeight), 1)]), _: 1 })) : u("", true), t(c).visible("finishNum") ? (l(), o(e, { align: "center", key: "finishNum", prop: "finishNum", label: "完成张数", "min-width": "100px" }, { default: i((a) => [h("span", null, s(a.row.finishNum), 1)]), _: 1 })) : u("", true), t(c).visible("finishWeight") ? (l(), o(e, { align: "center", key: "finishWeight", prop: "finishWeight", label: "完成重", "min-width": "100px" }, { default: i((a) => [h("span", null, s(a.row.finishWeight), 1)]), _: 1 })) : u("", true), t(S)(t(x).detail) ? (l(), o(e, { key: 5, align: "center", label: "查看切割状态", "min-width": "80px" }, { default: i((a) => [p(g, { icon: "el-icon-view", type: "primary", size: "default", onClick: (n) => D(a.row) }, null, 8, ["onClick"])]), _: 1 })) : u("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[I, t(y).loading]]), p(t(q)), p(G, { "detail-data": w.value, visible: v.value, "onUpdate:visible": r[0] || (r[0] = (a) => v.value = a) }, null, 8, ["detail-data", "visible"]), p(P, { "detail-data": w.value, visible: C.value, "onUpdate:visible": r[1] || (r[1] = (a) => C.value = a) }, null, 8, ["detail-data", "visible"]), p(K, { onChange: d.handleChange, "detail-data": w.value, visible: _.value, "onUpdate:visible": r[2] || (r[2] = (a) => _.value = a) }, null, 8, ["onChange", "detail-data", "visible"])]);
  };
} };
export {
  se as default
};
