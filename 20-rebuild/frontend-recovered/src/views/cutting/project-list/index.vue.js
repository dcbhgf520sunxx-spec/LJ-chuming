import { ref as m } from "vue";
import { resolveComponent as g } from "vue";
import { openBlock as s } from "vue";
import { createElementBlock as _ } from "vue";
import { createVNode as t } from "vue";
import { unref as n } from "vue";
import { withDirectives as D } from "vue";
import { createBlock as d } from "vue";
import { withCtx as a } from "vue";
import { Fragment as R } from "vue";
import { createElementVNode as l } from "vue";
import { toDisplayString as r } from "vue";
import { createCommentVNode as S } from "vue";
import { ElTableColumn as T } from "element-plus";
import { ElTag as V } from "element-plus";
import { vLoading as j } from "element-plus";
import { c as v } from "../../../modules/scheduling-2b0c95c3.js";
import { c as E } from "../../../modules/nestingList-7bbadefb.js";
import { x as H, o as I, P as M } from "../../../shared/runtime.js";
import P from "./module/header.vue.js";
import U from "./module/detail/index.vue.js";
import "../../../modules/project-data-5e9d497a.js";
import "./module/detail/machine-dialog/index.vue.js";
import "../../../modules/machine-10301ee2.js";
const $ = { class: "app-container" }, Z = { __name: "index", setup(q) {
  const h = m(), p = m(0), u = m(false), f = m({}), b = { get: ["contractRecord:get"] }, k = { add: false, edit: false, del: false, download: false }, { crud: i } = H({ title: "切割排产", sort: [], permission: { ...b }, optShow: { ...k }, crudApi: { ...v }, hasPagination: true }, h), { maxHeight: y } = I({ wrapperBox: ".contractRecord", paginate: true, extraHeight: 40 });
  async function x(c) {
    f.value = c, u.value = true;
  }
  function N(c) {
    p.value = c, p.value === 1 ? i.crudApi = { ...E } : i.crudApi = { ...v }, i.data = [], i.toQuery();
  }
  return (c, w) => {
    const o = T, C = V, W = g("common-button"), A = g("common-table"), B = j;
    return s(), _("div", $, [t(n(P), { onChange: N }), D((s(), d(A, { ref_key: "tableRef", ref: h, data: n(i).data, "empty-text": n(i).emptyText, "max-height": n(y) - 50, style: { width: "100%" } }, { default: a(() => [t(o, { prop: "index", label: "序号", align: "center", width: "60", type: "index" }), n(i).data && p.value === 0 ? (s(), _(R, { key: 0 }, [t(o, { key: "workshopInf", align: "center", prop: "workshopInf", "show-overflow-tooltip": true, label: "车间", "min-width": "40" }, { default: a((e) => [l("span", null, r(e.row.cutMachine.workshopInf), 1)]), _: 1 }), t(o, { key: "machineName", align: "center", prop: "machineName", "show-overflow-tooltip": true, label: "设备名称", "min-width": "40" }, { default: a((e) => [t(C, { style: { width: "100%" }, effect: "plain" }, { default: a(() => [l("span", null, r(e.row.cutMachine.machineName), 1)]), _: 2 }, 1024)]), _: 1 })], 64)) : (s(), d(o, { key: "projectName", "show-overflow-tooltip": true, label: "项目名称", align: "center", "min-width": "90" }, { default: a((e) => [l("span", null, r(e.row.projectName), 1)]), _: 1 })), t(o, { key: "plateNum", align: "center", prop: "plateNum", "show-overflow-tooltip": true, label: "任务数（张）", "min-width": "40" }, { default: a((e) => [l("span", null, r(e.row.plateNum ? e.row.plateNum : 0), 1)]), _: 1 }), t(o, { key: "plateWeight", align: "center", prop: "plateWeight", "show-overflow-tooltip": true, label: "任务量（kg）", "min-width": "40" }, { default: a((e) => [l("span", null, r(e.row.plateWeight ? e.row.plateWeight : 0), 1)]), _: 1 }), t(o, { key: "finishNum", align: "center", prop: "finishNum", "show-overflow-tooltip": true, label: "完成数（张）", "min-width": "40" }, { default: a((e) => [l("span", null, r(e.row.finishNum ? e.row.finishNum : 0), 1)]), _: 1 }), t(o, { key: "finishWeight", align: "center", prop: "finishWeight", "show-overflow-tooltip": true, label: "完成量（kg）", "min-width": "40" }, { default: a((e) => [l("span", null, r(e.row.finishWeight ? e.row.finishWeight : 0), 1)]), _: 1 }), p.value === 0 ? (s(), d(o, { key: 2, label: "操作", align: "center", "min-width": "90" }, { default: a((e) => [t(W, { icon: "el-icon-view", type: "primary", size: "default", onClick: (z) => x(e.row) }, null, 8, ["onClick"])]), _: 1 })) : S("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[B, n(i).loading]]), t(n(M)), t(U, { "detail-data": f.value, visible: u.value, "onUpdate:visible": w[0] || (w[0] = (e) => u.value = e) }, null, 8, ["detail-data", "visible"])]);
  };
} };
export {
  Z as default
};
