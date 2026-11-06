import { ref as c } from "vue";
import { resolveComponent as R } from "vue";
import { openBlock as a } from "vue";
import { createBlock as l } from "vue";
import { withCtx as m } from "vue";
import { createVNode as o } from "vue";
import { createElementVNode as h } from "vue";
import { withDirectives as I } from "vue";
import { unref as t } from "vue";
import { createCommentVNode as u } from "vue";
import { toDisplayString as g } from "vue";
import { createTextVNode as te } from "vue";
import { createElementBlock as ae } from "vue";
import { Fragment as oe } from "vue";
import { normalizeStyle as D } from "vue";
import { isRef as le } from "vue";
import { ElTableColumn as ne } from "element-plus";
import { ElPagination as re } from "element-plus";
import { ElDivider as ie } from "element-plus";
import { ElTag as se } from "element-plus";
import { vLoading as ue } from "element-plus";
import { r as pe, a as de } from "../../../../../../modules/productionLine-assistance-be4814e6.js";
import { u as me, J as ce, o as he, rL as r, bo as ge } from "../../../../../../shared/runtime.js";
const we = { style: { display: "flex", height: "100%" } }, ve = { style: { width: "50%" } }, fe = { style: { flex: "1" } }, Ee = { __name: "record-drawer", props: { visible: { type: Boolean, default: false }, weightStatus: { type: Number } }, emits: ["update:visible"], setup(P, { emit: F }) {
  const L = c(), U = F, j = P, { visible: A, handleClose: O } = me({ emit: U, props: j, field: "visible", showHook: Q }), { handleSizeChange: W, handleCurrentChange: $, total: G, setTotalPage: J, queryPage: k } = ce({ fetchHook: M }), { maxHeight: _ } = he({ mainBox: ".assistance-record", extraBox: [".el-drawer__header", ".titleLine"], wrapperBox: [".el-drawer__body"], navbar: false, clientHRepMainH: true }, L), S = { ARTIFACT: r.ARTIFACT, ASSEMBLE: { L: "部件", K: "ASSEMBLE", V: r.ASSEMBLE.V }, MACHINE_PART: r.MACHINE_PART }, K = c([["createTime", ["parse-time", "{y}-{m}-{d}"]], ["taskTypeEnum", ["parse-enum", r]]]);
  function Q() {
    y.value = [], M();
  }
  const N = c(false), V = c([]), T = c(false), y = c([]), E = c({}), p = c({}), B = c([]), z = c([]);
  async function M() {
    try {
      N.value = true, V.value = [], y.value = [];
      const { content: d, totalElements: i } = await pe({ ...E.value, ...k });
      V.value = d, J(i);
    } catch (d) {
      console.log("获取协同记录失败", d);
    } finally {
      N.value = false;
    }
  }
  async function X(d) {
    var i, x;
    if (!(!d || !d.id)) try {
      T.value = true;
      const e = await de({ changeId: d.id });
      e == null || e.forEach((s) => {
        var C;
        s.numberStr = (C = s == null ? void 0 : s.numbers) == null ? void 0 : C.join("、");
      }), y.value = e, B.value = (i = y.value) == null ? void 0 : i.filter((s) => s.boolOneCode), z.value = (x = y.value) == null ? void 0 : x.filter((s) => !s.boolOneCode);
    } catch (e) {
      y.value = [], console.log("获取协同记录详情失败", e);
    } finally {
      T.value = false;
    }
  }
  function Y(d) {
    p.value = d, X(d);
  }
  return (d, i) => {
    const x = R("common-radio-button"), e = ne, s = R("common-table"), C = re, q = ie, Z = se, ee = R("common-drawer"), H = ue;
    return a(), l(ee, { customClass: "assistance-record", ref_key: "drawerRef", ref: L, title: "协同记录", modelValue: t(A), "onUpdate:modelValue": i[1] || (i[1] = (b) => le(A) ? A.value = b : null), direction: "rtl", "before-close": t(O), size: "100%" }, { titleAfter: m(() => [o(x, { modelValue: E.value.taskTypeEnum, "onUpdate:modelValue": i[0] || (i[0] = (b) => E.value.taskTypeEnum = b), options: S, type: "enum", default: "", disabledVal: [S.MACHINE_PART.V], class: "filter-item", onChange: M }, null, 8, ["modelValue", "disabledVal"])]), content: m(() => {
      var b;
      return [h("div", we, [h("div", ve, [I((a(), l(s, { "highlight-current-row": "", stripe: false, onCurrentChange: Y, data: V.value, "data-format": K.value, "max-height": t(_), style: { width: "100%" } }, { default: m(() => [o(e, { label: "序号", type: "index", align: "center", width: "60" }), o(e, { align: "center", prop: "orderNumber", "show-overflow-tooltip": true, label: "排产工单号", "min-width": "120px" }), o(e, { prop: "createTime", "show-overflow-tooltip": true, label: "日期", width: "100px", align: "center" }), o(e, { prop: "user.name", "show-overflow-tooltip": true, label: "协同操作人", width: "100px", align: "center" }), E.value.taskTypeEnum !== t(r).MACHINE_PART.V ? (a(), l(e, { key: 0, align: "center", prop: "monomer.name", "show-overflow-tooltip": true, label: "单体", width: "100px" })) : u("", true), o(e, { prop: "quantity", "show-overflow-tooltip": true, label: "协同数（件/kg）", width: "120px", align: "center" }, { default: m(({ row: n }) => [h("span", null, g(P.weightStatus === t(ge).NET.V ? n.quantity + "/" + n.totalNetWeight : n.quantity + "/" + n.totalGrossWeight), 1)]), _: 1 }), E.value.taskTypeEnum !== t(r).MACHINE_PART.V ? (a(), l(e, { key: 1, prop: "group.name", "show-overflow-tooltip": true, label: "原生产组", "min-width": "150px" }, { default: m(({ row: n }) => {
        var w, v, f;
        return [h("span", null, g((w = n.workshop) == null ? void 0 : w.name) + ">" + g((v = n.productionLine) == null ? void 0 : v.name) + ">" + g((f = n.groups) == null ? void 0 : f.name), 1)];
      }), _: 1 })) : u("", true)]), _: 1 }, 8, ["data", "data-format", "max-height"])), [[H, N.value]]), o(C, { total: t(G), "current-page": t(k).pageNumber, "page-size": t(k).pageSize, style: { "margin-top": "8px" }, layout: "total, prev, pager, next, sizes", onSizeChange: t(W), onCurrentChange: t($) }, null, 8, ["total", "current-page", "page-size", "onSizeChange", "onCurrentChange"])]), o(q, { direction: "vertical", style: { height: "100%" } }), h("div", fe, [(b = y.value) != null && b.length ? (a(), ae(oe, { key: 1 }, [h("div", { style: D(`height: ${t(_) / 2}px;`) }, [I((a(), l(s, { data: B.value, "max-height": t(_), style: { width: "100%" } }, { default: m(() => [o(e, { label: "序号", type: "index", align: "center", width: "60" }), p.value.taskTypeEnum !== t(r).MACHINE_PART.V ? (a(), l(e, { key: 0, align: "center", prop: "orderNumber", "show-overflow-tooltip": true, label: "排产工单号", "min-width": "120px" })) : u("", true), p.value.taskTypeEnum === t(r).MACHINE_PART.V ? (a(), l(e, { key: 1, align: "center", prop: "cutNumber", "show-overflow-tooltip": true, label: "切割指令号", "min-width": "120px" })) : u("", true), p.value.taskTypeEnum !== t(r).MACHINE_PART.V ? (a(), l(e, { key: 2, prop: "area.name", "show-overflow-tooltip": true, label: "区域", width: "100px", align: "center" })) : u("", true), p.value.taskTypeEnum !== t(r).MACHINE_PART.V ? (a(), l(e, { key: 3, prop: "serialNumber", "show-overflow-tooltip": true, label: "编号", width: "100px", align: "center" })) : u("", true), o(e, { prop: "specification", "show-overflow-tooltip": true, label: "规格", "min-width": "100px", align: "center" }), p.value.taskTypeEnum !== t(r).MACHINE_PART.V ? (a(), l(e, { key: 4, prop: "length", "show-overflow-tooltip": true, label: "长度(mm)", width: "80", align: "center" })) : u("", true), o(e, { prop: "numberStr", "show-overflow-tooltip": true, label: "一物一码", "min-width": "80", align: "center" }), o(e, { prop: "quantity", "show-overflow-tooltip": true, label: "协同数量", width: "80", align: "center" }), o(e, { prop: "groups?.name", "show-overflow-tooltip": true, label: "协同生产组", "min-width": "150" }, { default: m(({ row: n }) => {
        var w, v, f;
        return [h("span", null, g((w = n.workshop) == null ? void 0 : w.name) + ">" + g((v = n.productionLine) == null ? void 0 : v.name) + ">" + g((f = n.groups) == null ? void 0 : f.name), 1)];
      }), _: 1 })]), _: 1 }, 8, ["data", "max-height"])), [[H, T.value]])], 4), o(q, { class: "titleLine" }, { default: m(() => i[3] || (i[3] = [h("span", { class: "title" }, "非一物一码", -1)])), _: 1, __: [3] }), h("div", { style: D(`height: ${t(_) / 2}px;`) }, [I((a(), l(s, { data: z.value, "max-height": t(_), style: { width: "100%" } }, { default: m(() => [o(e, { label: "序号", type: "index", align: "center", width: "60" }), p.value.taskTypeEnum !== t(r).MACHINE_PART.V ? (a(), l(e, { key: 0, align: "center", prop: "orderNumber", "show-overflow-tooltip": true, label: "排产工单号", "min-width": "120px" })) : u("", true), p.value.taskTypeEnum === t(r).MACHINE_PART.V ? (a(), l(e, { key: 1, align: "center", prop: "cutNumber", "show-overflow-tooltip": true, label: "切割指令号", "min-width": "120px" })) : u("", true), p.value.taskTypeEnum !== t(r).MACHINE_PART.V ? (a(), l(e, { key: 2, prop: "area.name", "show-overflow-tooltip": true, label: "区域", width: "100px", align: "center" })) : u("", true), p.value.taskTypeEnum !== t(r).MACHINE_PART.V ? (a(), l(e, { key: 3, prop: "serialNumber", "show-overflow-tooltip": true, label: "编号", width: "100px", align: "center" })) : u("", true), o(e, { prop: "specification", "show-overflow-tooltip": true, label: "规格", "min-width": "100px", align: "center" }), p.value.taskTypeEnum !== t(r).MACHINE_PART.V ? (a(), l(e, { key: 4, prop: "length", "show-overflow-tooltip": true, label: "长度(mm)", width: "80", align: "center" })) : u("", true), o(e, { prop: "quantity", "show-overflow-tooltip": true, label: "协同数量", width: "80", align: "center" }), o(e, { prop: "groups?.name", "show-overflow-tooltip": true, label: "协同生产组", "min-width": "150" }, { default: m(({ row: n }) => {
        var w, v, f;
        return [h("span", null, g((w = n.workshop) == null ? void 0 : w.name) + ">" + g((v = n.productionLine) == null ? void 0 : v.name) + ">" + g((f = n.groups) == null ? void 0 : f.name), 1)];
      }), _: 1 })]), _: 1 }, 8, ["data", "max-height"])), [[H, T.value]])], 4)], 64)) : (a(), l(Z, { key: 0, type: "info", size: "large" }, { default: m(() => i[2] || (i[2] = [te(" * 请先选择协同记录查看协同详情 ")])), _: 1, __: [2] }))])])];
    }), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  Ee as default
};
