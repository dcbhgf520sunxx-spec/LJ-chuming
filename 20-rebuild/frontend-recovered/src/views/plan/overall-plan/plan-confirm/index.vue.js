import { ref as j } from "vue";
import { resolveComponent as b } from "vue";
import { openBlock as a } from "vue";
import { createElementBlock as d } from "vue";
import { unref as t } from "vue";
import { Fragment as B } from "vue";
import { createVNode as p } from "vue";
import { withDirectives as D } from "vue";
import { createBlock as l } from "vue";
import { withCtx as s } from "vue";
import { createCommentVNode as n } from "vue";
import { createElementVNode as i } from "vue";
import { toDisplayString as c } from "vue";
import { createTextVNode as g } from "vue";
import { ElTableColumn as E } from "element-plus";
import { ElPopconfirm as H } from "element-plus";
import { vLoading as R } from "element-plus";
import { c as S } from "../../../../modules/plan-make-b1cab552.js";
import { m as L, x as V, o as T, P as q } from "../../../../shared/runtime.js";
import z from "./module/header.vue.js";
import { f as A } from "../../../../modules/plan-d12d7ccf.js";
const M = { class: "app-container" }, O = { key: 1, style: { color: "red", "font-size": "14px" } }, J = { __name: "index", setup(U) {
  const { globalProject: u } = L(["globalProject"]), y = { add: false, edit: false, del: false, download: false }, f = j(), { CRUD: w, crud: _, columns: r } = V({ title: "工作确认", sort: ["id.desc"], permission: { ...A }, optShow: { ...y }, requiredQuery: ["productId"], crudApi: { ...S }, hasPagination: true }, f), { maxHeight: h } = T({ wrapperBox: ".plan-confirm", paginate: true, extraHeight: 40 });
  async function x(N) {
  }
  return w.HOOK.beforeRefresh = () => false, (N, m) => {
    const o = E, v = b("common-button"), k = H, C = b("common-table"), P = R;
    return a(), d("div", M, [t(u) && t(u).projectContentList && t(u).projectContentList.length > 0 ? (a(), d(B, { key: 0 }, [p(t(z)), D((a(), l(C, { ref_key: "tableRef", ref: f, data: [{ id: 1 }], "empty-text": t(_).emptyText, "max-height": t(h), showEmptySymbol: false, "return-source-data": "", style: { width: "100%", "margin-top": "20px" } }, { default: s(() => [p(o, { label: "序号", type: "index", align: "center", width: "60" }), t(r).visible("name") ? (a(), l(o, { key: "name", prop: "name", "show-overflow-tooltip": true, label: "日期", width: "150" })) : n("", true), t(r).visible("axis") ? (a(), l(o, { key: "axis", prop: "axis", "show-overflow-tooltip": true, label: "提交人", width: "120" })) : n("", true), t(r).visible("className") ? (a(), l(o, { key: "sort", prop: "sort", label: "单体名称", align: "center" }, { default: s((e) => [i("span", null, c(e.row.className), 1)]), _: 1 })) : n("", true), m[1] || (m[1] = g()), t(r).visible("className") ? (a(), l(o, { key: "sort", prop: "sort", label: "工作内容", align: "center" }, { default: s((e) => [i("span", null, c(e.row.className), 1)]), _: 1 })) : n("", true), t(r).visible("className") ? (a(), l(o, { key: "sort", prop: "sort", label: "区域", align: "center" }, { default: s((e) => [i("span", null, c(e.row.className), 1)]), _: 1 })) : n("", true), t(r).visible("className") ? (a(), l(o, { key: "sort", prop: "sort", label: "计划完成（天）", align: "center" }, { default: s((e) => [i("span", null, c(e.row.className), 1)]), _: 1 })) : n("", true), t(r).visible("className") ? (a(), l(o, { key: "sort", prop: "sort", label: "实际完成（天）", align: "center" }, { default: s((e) => [i("span", null, c(e.row.className), 1)]), _: 1 })) : n("", true), t(r).visible("className") ? (a(), l(o, { key: "sort", prop: "sort", label: "完成度", align: "center" }, { default: s((e) => [i("span", null, c(e.row.className), 1)]), _: 1 })) : n("", true), t(r).visible("className") ? (a(), l(o, { key: "sort", prop: "sort", label: "单位", align: "center", width: "60" }, { default: s((e) => [i("span", null, c(e.row.className), 1)]), _: 1 })) : n("", true), t(r).visible("className") ? (a(), l(o, { key: "sort", prop: "sort", label: "完成量", align: "center" }, { default: s((e) => [i("span", null, c(e.row.className), 1)]), _: 1 })) : n("", true), t(r).visible("className") ? (a(), l(o, { key: "sort", prop: "sort", label: "操作人", align: "center" }, { default: s((e) => [i("span", null, c(e.row.className), 1)]), _: 1 })) : n("", true), p(o, { label: "操作", width: "160px", align: "center", fixed: "right" }, { default: s((e) => [p(k, { title: "一旦确认，将不能修改，确认完成?", onConfirm: (F) => x(e.row.name) }, { reference: s(() => [p(v, { type: "primary", size: "default" }, { default: s(() => m[0] || (m[0] = [g("确定完成")])), _: 1, __: [0] })]), _: 2 }, 1032, ["onConfirm"])]), _: 1 })]), _: 1, __: [1] }, 8, ["empty-text", "max-height"])), [[P, t(_).loading]]), p(t(q))], 64)) : (a(), d("div", O, "*请先前去合同管理模块添加项目内容"))]);
  };
} };
export {
  J as default
};
