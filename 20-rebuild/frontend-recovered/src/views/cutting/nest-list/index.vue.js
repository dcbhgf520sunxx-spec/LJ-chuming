import { ref as g } from "vue";
import { resolveComponent as C } from "vue";
import { openBlock as a } from "vue";
import { createElementBlock as L } from "vue";
import { createElementVNode as m } from "vue";
import { createVNode as f } from "vue";
import { unref as e } from "vue";
import { withDirectives as S } from "vue";
import { createBlock as o } from "vue";
import { withCtx as l } from "vue";
import { createTextVNode as p } from "vue";
import { toDisplayString as d } from "vue";
import { createCommentVNode as s } from "vue";
import { ElTableColumn as O } from "element-plus";
import { ElTag as U } from "element-plus";
import { vLoading as B } from "element-plus";
import { c as W, a as j } from "../../../modules/radan-controller-25ebed6e.js";
import { x as G, o as H, m0 as I, m1 as b, p as M, m2 as v, P as q } from "../../../shared/runtime.js";
import K from "./module/header.vue.js";
import { n as Q } from "../../../modules/cutting-457c256f.js";
import $ from "./module/del.vue.js";
const z = { class: "app-container" }, F = { class: "head-container" }, J = { key: 0 }, re = { __name: "index", setup(X) {
  const k = g(), N = g(false), y = g({}), _ = g(false), D = { add: false, edit: false, del: false, download: false }, { crud: h, CRUD: E, columns: u } = G({ title: "套料工单", sort: [], permission: { ...Q }, optShow: { ...D }, crudApi: { ...W }, hasPagination: true, formStore: true }, k);
  E.HOOK.handleRefresh = (c, i) => {
    i.data.content = i.data.content.map((t, w) => (t.subList = [], t.rowIndex = w, _.value && x(), t));
  };
  async function x() {
    try {
      const c = await j({ sort: ["createTime.desc"], projectId: y.value.projectId });
      h.data[y.value.rowIndex].subList = c.content;
    } catch {
      console.log("请求接口数据失败");
    } finally {
      _.value = false;
    }
  }
  async function V(c, i) {
    y.value = c, console.log(c, i), N.value = true;
    try {
      const t = await j({ projectId: c.projectId });
      console.log("data", t), c.subList = t.content;
    } catch {
      console.log("请求接口数据失败");
    }
    N.value = false;
  }
  const { maxHeight: R } = H({ wrapperBox: ".contractRecord", paginate: true, extraHeight: 40 });
  function A() {
    _.value = true, h.toQuery();
  }
  return (c, i) => {
    const t = O, w = U, T = C("common-table"), P = B;
    return a(), L("div", z, [m("div", F, [f(e(K))]), S((a(), o(T, { ref_key: "tableRef", ref: k, data: e(h).data, "empty-text": e(h).emptyText, "max-height": e(R), "row-key": "projectId", style: { width: "100%" }, onExpandChange: V }, { default: l(() => [f(t, { type: "expand" }, { default: l((n) => [S((a(), o(T, { data: n.row.subList, "row-key": "id", style: { width: "100%" }, border: "" }, { default: l(() => [f(t, { prop: "index", label: "序号", align: "center", width: "60", type: "index" }), e(u).visible("thick") ? (a(), o(t, { "header-align": "center", key: "thick", prop: "thick", "show-overflow-tooltip": true, style: { width: "100%" }, label: "钢板厚度", align: "center", "min-width": "60" }, { default: l((r) => [p(d(r.row.thick), 1)]), _: 2 }, 1024)) : s("", true), e(u).visible("material") ? (a(), o(t, { "header-align": "center", key: "material", prop: "material", "show-overflow-tooltip": true, style: { width: "100%" }, label: "材质", align: "center", "min-width": "60" }, { default: l((r) => [p(d(r.row.material), 1)]), _: 2 }, 1024)) : s("", true), e(u).visible("sum") ? (a(), o(t, { "header-align": "center", key: "sum", prop: "sum", "show-overflow-tooltip": true, style: { width: "100%" }, label: "零件数量", align: "center", "min-width": "60" }, { default: l((r) => [p(d(r.row.sum), 1)]), _: 2 }, 1024)) : s("", true), e(u).visible("reduce") ? (a(), o(t, { "header-align": "center", key: "reduce", prop: "reduce", "show-overflow-tooltip": true, style: { width: "100%" }, label: "零件重量", align: "center", "min-width": "60" }, { default: l((r) => [p(d(r.row.reduce), 1)]), _: 2 }, 1024)) : s("", true), e(u).visible("relationType") ? (a(), o(t, { "header-align": "center", key: "relationType", prop: "relationType", "show-overflow-tooltip": true, style: { width: "50%" }, label: "零件属性", align: "center", "min-width": "60" }, { default: l((r) => [r.row.relationType && r.row.relationType === e(I).PART_BOARD.V ? (a(), o(w, { key: 0, type: "success" }, { default: l(() => i[0] || (i[0] = [p(" 零件板 ")])), _: 1, __: [0] })) : r.row.relationType && r.row.relationType === e(I).WING_PLATE.V ? (a(), o(w, { key: 1, type: "danger" }, { default: l(() => i[1] || (i[1] = [p(" 翼腹板 ")])), _: 1, __: [1] })) : s("", true)]), _: 2 }, 1024)) : s("", true), e(u).visible("state") ? (a(), o(t, { align: "center", key: "state", prop: "state", "show-overflow-tooltip": true, label: "状态", "min-width": "40" }, { default: l((r) => [m("span", null, [r.row.state && r.row.state === e(b).UPLOADING_UP.V ? (a(), o(w, { key: 0, style: { width: "100%" }, effect: "plain", type: "warning" }, { default: l(() => i[2] || (i[2] = [p(" 已上传 ")])), _: 1, __: [2] })) : r.row.state && r.row.state === e(b).NOT_UPLOAD.V ? (a(), o(w, { key: 1, style: { width: "100%" }, effect: "plain", type: "danger" }, { default: l(() => i[3] || (i[3] = [p(" 未上传 ")])), _: 1, __: [3] })) : r.row.state && r.row.state === e(b).UPLOADING_UP_ENDING.V ? (a(), o(w, { key: 2, style: { width: "100%" }, effect: "plain", type: "success" }, { default: l(() => i[4] || (i[4] = [p(" 套料结束 ")])), _: 1, __: [4] })) : s("", true)])]), _: 2 }, 1024)) : s("", true), e(u).visible("currentName") ? (a(), o(t, { align: "center", key: "currentName", prop: "currentName", "show-overflow-tooltip": true, label: "投料人", "min-width": "40" }, { default: l((r) => [r.row.importTime ? (a(), L("span", J, d(r.row.currentName) + " " + d(e(M)(r.row.importTime, "{y}-{m}-{d}")), 1)) : s("", true)]), _: 2 }, 1024)) : s("", true), f(t, { width: "350px", "show-overflow-tooltip": true, label: "操作", align: "center" }, { default: l((r) => [f(e($), { onSuccess: A, onGetPlate: x, data: r.row }, null, 8, ["data"])]), _: 2 }, 1024)]), _: 2 }, 1032, ["data"])), [[P, n.row.loadingList]])]), _: 1 }), f(t, { prop: "index", label: "序号", align: "center", width: "60", type: "index" }), e(u).visible("projectName") ? (a(), o(t, { "header-align": "center", key: "projectName", prop: "projectName", "show-overflow-tooltip": true, label: "所属项目", "min-width": "60" }, { default: l((n) => [m("span", null, d(n.row.projectNumber) + "-" + d(n.row.projectName), 1)]), _: 1 })) : s("", true), e(u).visible("sum") ? (a(), o(t, { "header-align": "center", key: "sum", prop: "sum", align: "center", "show-overflow-tooltip": true, label: "零件总数", "min-width": "60" }, { default: l((n) => [m("span", null, d(n.row.sum), 1)]), _: 1 })) : s("", true), e(u).visible("reduce") ? (a(), o(t, { "header-align": "center", key: "reduce", prop: "reduce", align: "center", "show-overflow-tooltip": true, label: "零件重量", "min-width": "60" }, { default: l((n) => [m("span", null, d(n.row.reduce), 1)]), _: 1 })) : s("", true), e(u).visible("totalNum") ? (a(), o(t, { "header-align": "center", key: "totalNum", prop: "totalNum", align: "center", "show-overflow-tooltip": true, label: "已排套数", "min-width": "60" }, { default: l((n) => [m("span", null, d(n.row.totalNum), 1)]), _: 1 })) : s("", true), e(u).visible("projectName") ? (a(), o(t, { "header-align": "center", key: "projectName", prop: "projectName", align: "center", "show-overflow-tooltip": true, label: "未排套数", "min-width": "60" }, { default: l((n) => [m("span", null, d(n.row.sum - n.row.totalNum), 1)]), _: 1 })) : s("", true), e(u).visible("plateNum") ? (a(), o(t, { "header-align": "center", key: "plateNum", prop: "plateNum", align: "center", "show-overflow-tooltip": true, label: "使用钢板数", "min-width": "60" }, { default: l((n) => [m("span", null, d(n.row.plateNum), 1)]), _: 1 })) : s("", true), e(u).visible("plateWeight") ? (a(), o(t, { "header-align": "center", key: "plateWeight", prop: "plateWeight", align: "center", "show-overflow-tooltip": true, label: "使用钢板重量", "min-width": "60" }, { default: l((n) => [m("span", null, d(n.row.plateWeight), 1)]), _: 1 })) : s("", true), e(u).visible("nestingState") ? (a(), o(t, { align: "center", key: "nestingState", prop: "nestingState", "show-overflow-tooltip": true, label: "状态", "min-width": "40" }, { default: l((n) => [m("span", null, [n.row.nestingState === e(v).NOT_LINED_UP.V ? (a(), o(w, { key: 0, style: { width: "100%" }, effect: "plain", type: "danger" }, { default: l(() => i[5] || (i[5] = [p(" 未套料 ")])), _: 1, __: [5] })) : n.row.nestingState && n.row.nestingState === e(v).PARTIAL_ROW_SETS.V ? (a(), o(w, { key: 1, style: { width: "100%" }, effect: "plain", type: "warning" }, { default: l(() => i[6] || (i[6] = [p(" 部分套料 ")])), _: 1, __: [6] })) : n.row.nestingState && n.row.nestingState === e(v).LINED_UP.V ? (a(), o(w, { key: 2, style: { width: "100%" }, effect: "plain", type: "success" }, { default: l(() => i[7] || (i[7] = [p(" 套料结束 ")])), _: 1, __: [7] })) : s("", true)])]), _: 1 })) : s("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[P, e(h).loading]]), f(e(q))]);
  };
} };
export {
  re as default
};
