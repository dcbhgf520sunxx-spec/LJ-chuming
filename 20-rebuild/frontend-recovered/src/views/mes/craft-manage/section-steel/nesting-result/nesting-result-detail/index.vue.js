import { ref as c } from "vue";
import { watch as ee } from "vue";
import { resolveComponent as k } from "vue";
import { resolveDirective as te } from "vue";
import { openBlock as h } from "vue";
import { createElementBlock as ae } from "vue";
import { withDirectives as p } from "vue";
import { vShow as L } from "vue";
import { createElementVNode as i } from "vue";
import { createVNode as s } from "vue";
import { withCtx as n } from "vue";
import { createTextVNode as f } from "vue";
import { toDisplayString as d } from "vue";
import { createBlock as x } from "vue";
import { unref as o } from "vue";
import { ElMessageBox as M } from "element-plus";
import { ElNotification as E } from "element-plus";
import { ElTag as ne } from "element-plus";
import { ElTableColumn as se } from "element-plus";
import { ElPopconfirm as oe } from "element-plus";
import { n as le, a as ie, _ as ue, b as Q, d as U } from "../nesting-file/index.vue.js";
import { _ as ce, o as re, nl as I, nq as b } from "../../../../../../shared/runtime.js";
import "../../../../../../modules/nesting-setting-83aca0bd.js";
const de = { class: "app-container" }, me = { class: "my-code" }, pe = { class: "batch-operation head-container", style: { display: "flex", "justify-content": "space-between" } }, fe = { class: "filter-item" }, be = { __name: "index", props: { batchRow: { type: Object, default: () => {
} } }, emits: ["success"], setup(W, { emit: P }) {
  const T = P, r = W, { maxHeight: j } = re({ paginate: true }), O = c(), R = c({}), C = c(false), g = c([]), V = c([]), _ = c(), y = c(), N = c([]), D = c([]);
  ee(() => {
    var t;
    return (t = r.batchRow) == null ? void 0 : t.id;
  }, (t) => {
    _.value = void 0, y.value = void 0, t && ($(), m());
  }, { deep: true, immediate: true });
  async function m() {
    var t, e;
    if ((t = r.batchRow) != null && t.id) try {
      const { content: l } = await le({ id: (e = r.batchRow) == null ? void 0 : e.id, monomerId: _.value, areaId: y.value });
      V.value = l;
    } catch {
      console.log("获取套料批次数据失败");
    }
  }
  async function $() {
    var t, e;
    if ((t = r.batchRow) != null && t.id) try {
      const { content: l } = await ie({ id: (e = r.batchRow) == null ? void 0 : e.id });
      N.value = l || [];
    } catch (l) {
      console.log("获取单体区域的列表失败", l);
    }
  }
  function A(t) {
    var e;
    t && (D.value = (e = N.value.find((l) => l.id === t)) == null ? void 0 : e.areaList), m();
  }
  function q() {
    m();
  }
  function H(t, e) {
    return t.statusIssueEnum === b.COMPLETE.V;
  }
  function F(t) {
    g.value = t;
  }
  function X() {
    M.confirm("是否确认批量删除选中数据的套料成果？", { confirmButtonText: "确定", cancelButtonText: "取消", type: "warning", draggable: true }).then(async () => {
      const t = [];
      g.value.map((e) => {
        t.push(e.id);
      }), await Q(t), m(), T("success"), E({ title: "批量删除成功", type: "success", duration: 2500 });
    }).catch(() => {
      console.log("删除失败");
    });
  }
  function G() {
    M.confirm("是否确认批量下发选中数据？", { confirmButtonText: "确定", cancelButtonText: "取消", type: "warning", draggable: true }).then(async () => {
      const t = [];
      g.value.map((e) => {
        t.push(e.id);
      }), await U(t), m(), T("success"), E({ title: "批量下发成功", type: "success", duration: 2500 });
    }).catch(() => {
      console.log("批量下发失败");
    });
  }
  function J(t) {
    C.value = true, R.value = t;
  }
  async function K(t) {
    try {
      const e = [];
      e.push(t.id), await U(e), m(), T("success"), E({ title: "下发成功", type: "success", duration: 2500 });
    } catch {
      console.log("下发失败");
    }
  }
  async function Y(t) {
    try {
      const e = [];
      e.push(t.id), await Q(e), m(), T("success"), E({ title: "删除套料成果成功", type: "success", duration: 2500 });
    } catch {
      console.log("删除套料成果失败");
    }
  }
  return (t, e) => {
    const l = ne, B = k("common-select"), v = k("common-button"), u = se, S = oe, Z = k("common-table"), w = te("permission");
    return h(), ae("div", de, [p(i("div", me, "*点击左侧项目行查看详情", 512), [[L, !r.batchRow.id]]), p(i("div", null, [i("div", pe, [i("div", null, [s(l, { class: "filter-item", size: "large", style: { "align-self": "center" } }, { default: n(() => [f("当前项目：" + d(r.batchRow.projectName), 1)]), _: 1 }), s(B, { modelValue: _.value, "onUpdate:modelValue": e[0] || (e[0] = (a) => _.value = a), options: N.value, type: "other", "data-structure": { key: "id", label: "name", value: "id" }, size: "default", clearable: "", class: "filter-item", style: { width: "240px" }, placeholder: "选择单体", onChange: A }, null, 8, ["modelValue", "options"]), s(B, { modelValue: y.value, "onUpdate:modelValue": e[1] || (e[1] = (a) => y.value = a), options: D.value, type: "other", "data-structure": { key: "id", label: "name", value: "id" }, size: "default", clearable: "", noDataText: _.value ? "暂无数据" : "未选择单体", class: "filter-item", style: { width: "240px" }, placeholder: "选择区域", onChange: q }, null, 8, ["modelValue", "options", "noDataText"])]), i("div", fe, [p((h(), x(v, { type: "danger", size: "default", disabled: g.value.length === 0, onClick: X }, { default: n(() => e[3] || (e[3] = [f(" 批量删除 ")])), _: 1, __: [3] }, 8, ["disabled"])), [[w, o(I).del]]), p((h(), x(v, { type: "success", size: "default", disabled: g.value.length === 0, onClick: G }, { default: n(() => e[4] || (e[4] = [f(" 批量下发 ")])), _: 1, __: [4] }, 8, ["disabled"])), [[w, o(I).issued]])])]), s(Z, { ref_key: "tableRef", ref: O, data: V.value, "empty-text": "暂无数据", "max-height": o(j), "row-key": "id", style: { width: "100%" }, onSelectionChange: F }, { default: n(() => [s(u, { type: "selection", align: "center", width: "60", class: "selection", selectable: H }), s(u, { key: "batchNumber", prop: "batchNumber", "show-overflow-tooltip": true, label: "套料批次号", align: "center" }, { default: n(({ row: a }) => [i("span", null, d(a.batchNumber), 1)]), _: 1 }), s(u, { key: "userName", prop: "userName", "show-overflow-tooltip": true, label: "套料操作人", align: "center" }, { default: n(({ row: a }) => [i("span", null, d(a.userName), 1)]), _: 1 }), s(u, { key: "assembleTotalQuantity", prop: "assembleTotalQuantity", "show-overflow-tooltip": true, label: "清单部件总数", align: "center" }, { default: n(({ row: a }) => [i("span", null, d(a.assembleTotalQuantity), 1)]), _: 1 }), s(u, { key: "assembleTotalNetWeight", prop: "assembleTotalNetWeight", "show-overflow-tooltip": true, label: "部件总重", align: "center" }, { default: n(({ row: a }) => [i("span", null, d(a.assembleTotalNetWeight), 1)]), _: 1 }), s(u, { key: "nestingTotalQuantity", prop: "nestingTotalQuantity", "show-overflow-tooltip": true, label: "套料总数", align: "center" }, { default: n(({ row: a }) => [i("span", null, d(a.nestingTotalQuantity), 1)]), _: 1 }), s(u, { key: "typesettingTotalNetWeight", prop: "typesettingTotalNetWeight", "show-overflow-tooltip": true, label: "母材总重", align: "center" }, { default: n(({ row: a }) => [i("span", null, d(a.typesettingTotalNetWeight), 1)]), _: 1 }), s(u, { key: "statusIssueEnum", prop: "statusIssueEnum", "show-overflow-tooltip": true, label: "状态", align: "center" }, { default: n(({ row: a }) => [s(l, { type: o(b).V[a.statusIssueEnum].T }, { default: n(() => [f(d(o(b).VL[a.statusIssueEnum]), 1)]), _: 2 }, 1032, ["type"])]), _: 1 }), s(u, { "show-overflow-tooltip": true, label: "操作", "min-width": "200px", align: "center" }, { default: n(({ row: a }) => [p((h(), x(v, { type: "primary", size: "default", onClick: (z) => J(a) }, { default: n(() => e[5] || (e[5] = [f("查看")])), _: 2, __: [5] }, 1032, ["onClick"])), [[w, o(I).detail]]), s(S, { "confirm-button-text": "确定", "cancel-button-text": "取消", title: "确定下发吗?", onConfirm: (z) => K(a) }, { reference: n(() => [p((h(), x(v, { size: "default", type: "success", disabled: a.statusIssueEnum === o(b).ISSUED.V || a.statusIssueEnum === o(b).EXPIRED.V }, { default: n(() => e[6] || (e[6] = [f(" 下发 ")])), _: 2, __: [6] }, 1032, ["disabled"])), [[w, o(I).issued]])]), _: 2 }, 1032, ["onConfirm"]), s(S, { "confirm-button-text": "确定", "cancel-button-text": "取消", "icon-color": "red", title: "确定删除吗?", onConfirm: (z) => Y(a) }, { reference: n(() => [p((h(), x(v, { size: "default", type: "danger", disabled: a.statusIssueEnum === o(b).ISSUED.V || a.statusIssueEnum === o(b).PRODUCTION.V }, { default: n(() => e[7] || (e[7] = [f(" 删除 ")])), _: 2, __: [7] }, 1032, ["disabled"])), [[w, o(I).del]])]), _: 2 }, 1032, ["onConfirm"])]), _: 1 })]), _: 1 }, 8, ["data", "max-height"]), s(ue, { visible: C.value, "onUpdate:visible": e[2] || (e[2] = (a) => C.value = a), "detail-data": R.value, monomerId: _.value, areaId: y.value }, null, 8, ["visible", "detail-data", "monomerId", "areaId"])], 512), [[L, r.batchRow.id]])]);
  };
} }, ve = ce(be, [["__scopeId", "data-v-ba15274e"]]);
export {
  ve as default
};
