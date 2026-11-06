import { ref as u } from "vue";
import { resolveComponent as A } from "vue";
import { openBlock as n } from "vue";
import { createBlock as r } from "vue";
import { withCtx as p } from "vue";
import { createVNode as o } from "vue";
import { createElementVNode as f } from "vue";
import { withDirectives as R } from "vue";
import { unref as t } from "vue";
import { createCommentVNode as d } from "vue";
import { toDisplayString as c } from "vue";
import { createTextVNode as Z } from "vue";
import { isRef as $ } from "vue";
import { ElTableColumn as ee } from "element-plus";
import { ElPagination as te } from "element-plus";
import { ElDivider as ae } from "element-plus";
import { ElTag as oe } from "element-plus";
import { vLoading as le } from "element-plus";
import { r as ne, a as re } from "../../../../../../modules/productionLine-assistance-4576379e.js";
import { u as ie, J as se, o as ue, ce as i } from "../../../../../../shared/runtime.js";
const pe = { style: { display: "flex", height: "100%" } }, ce = { style: { width: "45%" } }, de = { style: { flex: "1" } }, fe = { __name: "record-drawer", props: { visible: { type: Boolean, default: false } }, emits: ["update:visible"], setup(I, { emit: M }) {
  const N = u(), L = M, z = I, { visible: b, handleClose: B } = ie({ emit: L, props: z, field: "visible", showHook: j }), { handleSizeChange: q, handleCurrentChange: D, total: S, setTotalPage: U, queryPage: C } = se({ fetchHook: E }), { maxHeight: V } = ue({ mainBox: ".assistance-record", extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body"], navbar: false, clientHRepMainH: true }, N), O = { BOX: i.BOX, CELL: i.CELL, MACHINE_PART: i.MACHINE_PART }, X = u([["createTime", ["parse-time", "{y}-{m}-{d}"]], ["taskTypeEnum", ["parse-enum", i]]]);
  function j() {
    m.value = [], E();
  }
  const x = u(false), k = u([]), T = u(false), m = u([]), y = u({}), h = u({});
  async function E() {
    try {
      x.value = true, k.value = [], m.value = [];
      const { content: l, totalElements: a } = await ne({ ...y.value, ...C });
      k.value = l, U(a);
    } catch (l) {
      console.log("获取协同记录失败", l);
    } finally {
      x.value = false;
    }
  }
  async function F(l) {
    if (!(!l || !l.id)) try {
      T.value = true;
      const a = await re({ changeId: l.id });
      m.value = a;
    } catch (a) {
      m.value = [], console.log("获取协同记录详情失败", a);
    } finally {
      T.value = false;
    }
  }
  function J(l) {
    h.value = l, F(l);
  }
  return (l, a) => {
    const W = A("common-radio-button"), e = ee, H = A("common-table"), G = te, K = ae, Q = oe, Y = A("common-drawer"), P = le;
    return n(), r(Y, { customClass: "assistance-record", ref_key: "drawerRef", ref: N, title: "协同记录", modelValue: t(b), "onUpdate:modelValue": a[1] || (a[1] = (g) => $(b) ? b.value = g : null), direction: "rtl", "before-close": t(B), size: "100%" }, { titleAfter: p(() => [o(W, { modelValue: y.value.taskTypeEnum, "onUpdate:modelValue": a[0] || (a[0] = (g) => y.value.taskTypeEnum = g), options: O, type: "enum", default: "", class: "filter-item", onChange: E }, null, 8, ["modelValue"])]), content: p(() => {
      var g;
      return [f("div", pe, [f("div", ce, [R((n(), r(H, { "highlight-current-row": "", stripe: false, onCurrentChange: J, data: k.value, "data-format": X.value, "max-height": t(V), style: { width: "100%" } }, { default: p(() => [o(e, { label: "序号", type: "index", align: "center", width: "60" }), o(e, { align: "center", prop: "orderNumber", "show-overflow-tooltip": true, label: "排产工单号", "min-width": "120px" }), o(e, { prop: "createTime", "show-overflow-tooltip": true, label: "日期", width: "100px", align: "center" }), o(e, { prop: "user.name", "show-overflow-tooltip": true, label: "协同操作人", width: "100px", align: "center" }), t(i).MACHINE_PART.V ? (n(), r(e, { key: 0, align: "center", prop: "monomer.name", "show-overflow-tooltip": true, label: "单体", width: "100px" })) : d("", true), o(e, { prop: "quantity", "show-overflow-tooltip": true, label: "协同数（件/kg）", width: "120px", align: "center" }, { default: p(({ row: s }) => [f("span", null, c(s.quantity) + " / " + c(s.totalNetWeight), 1)]), _: 1 }), y.value.taskTypeEnum !== t(i).MACHINE_PART.V ? (n(), r(e, { key: 1, prop: "group.name", "show-overflow-tooltip": true, label: "原生产组", "min-width": "150px" }, { default: p(({ row: s }) => {
        var w, v, _;
        return [f("span", null, c((w = s.workshop) == null ? void 0 : w.name) + ">" + c((v = s.productionLine) == null ? void 0 : v.name) + ">" + c((_ = s.groups) == null ? void 0 : _.name), 1)];
      }), _: 1 })) : d("", true)]), _: 1 }, 8, ["data", "data-format", "max-height"])), [[P, x.value]]), o(G, { total: t(S), "current-page": t(C).pageNumber, "page-size": t(C).pageSize, style: { "margin-top": "8px" }, layout: "total, prev, pager, next, sizes", onSizeChange: t(q), onCurrentChange: t(D) }, null, 8, ["total", "current-page", "page-size", "onSizeChange", "onCurrentChange"])]), o(K, { direction: "vertical", style: { height: "100%" } }), f("div", de, [(g = m.value) != null && g.length ? R((n(), r(H, { key: 1, data: m.value, "max-height": t(V), style: { width: "100%" } }, { default: p(() => [o(e, { label: "序号", type: "index", align: "center", width: "60" }), h.value.taskTypeEnum !== t(i).MACHINE_PART.V ? (n(), r(e, { key: 0, align: "center", prop: "orderNumber", "show-overflow-tooltip": true, label: "排产工单号", "min-width": "120px" })) : d("", true), h.value.taskTypeEnum === t(i).MACHINE_PART.V ? (n(), r(e, { key: 1, align: "center", prop: "cutNumber", "show-overflow-tooltip": true, label: "切割指令号", "min-width": "120px" })) : d("", true), h.value.taskTypeEnum !== t(i).MACHINE_PART.V ? (n(), r(e, { key: 2, prop: "area.name", "show-overflow-tooltip": true, label: "区域", width: "100px", align: "center" })) : d("", true), h.value.taskTypeEnum !== t(i).MACHINE_PART.V ? (n(), r(e, { key: 3, prop: "serialNumber", "show-overflow-tooltip": true, label: "编号", width: "100px", align: "center" })) : d("", true), o(e, { prop: "specification", "show-overflow-tooltip": true, label: "规格", "min-width": "100px", align: "center" }), h.value.taskTypeEnum !== t(i).MACHINE_PART.V ? (n(), r(e, { key: 4, prop: "length", "show-overflow-tooltip": true, label: "长度(mm)", width: "80", align: "center" })) : d("", true), o(e, { prop: "quantity", "show-overflow-tooltip": true, label: "协同数量", width: "80", align: "center" }), o(e, { prop: "groups?.name", "show-overflow-tooltip": true, label: "协同生产组", "min-width": "150" }, { default: p(({ row: s }) => {
        var w, v, _;
        return [f("span", null, c((w = s.workshop) == null ? void 0 : w.name) + ">" + c((v = s.productionLine) == null ? void 0 : v.name) + ">" + c((_ = s.groups) == null ? void 0 : _.name), 1)];
      }), _: 1 })]), _: 1 }, 8, ["data", "max-height"])), [[P, T.value]]) : (n(), r(Q, { key: 0, type: "info", size: "large" }, { default: p(() => a[2] || (a[2] = [Z(" * 请先选择协同记录查看协同详情 ")])), _: 1, __: [2] }))])])];
    }), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  fe as default
};
