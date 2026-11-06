import { inject as K } from "vue";
import { ref as f } from "vue";
import { computed as I } from "vue";
import { resolveComponent as x } from "vue";
import { resolveDirective as Q } from "vue";
import { openBlock as _ } from "vue";
import { createElementBlock as N } from "vue";
import { createVNode as e } from "vue";
import { createSlots as Z } from "vue";
import { unref as o } from "vue";
import { withCtx as i } from "vue";
import { createCommentVNode as H } from "vue";
import { createBlock as R } from "vue";
import { createElementVNode as p } from "vue";
import { toDisplayString as s } from "vue";
import { createTextVNode as d } from "vue";
import { Fragment as V } from "vue";
import { withDirectives as ee } from "vue";
import { ElTag as te } from "element-plus";
import { ElInput as ae } from "element-plus";
import { ElTableColumn as oe } from "element-plus";
import { ElLink as le } from "element-plus";
import { _ as ie, jX as ne, gt as se, o as re, j_ as pe, cO as ce, am as me, wc as E, jl as ue, c as T, wd as h, iX as g, z as B, i as de, jG as fe, jH as he, k5 as we, wb as _e, T as ge, R as be, S as ve, jP as ye, L as xe, wQ as Ne, wR as Ee, ba as q } from "../../../../shared/runtime.js";
const Te = { class: "table-header" }, ke = { class: "print-wrap" }, Me = { key: 0, style: { "margin-bottom": "10px" } }, Ce = { style: { color: "#0d84ff" } }, Pe = { style: { color: "#0d84ff" } }, Re = { style: { color: "#0d84ff" } }, Ve = { class: "table-remark" }, Le = { __name: "detail", setup(Se) {
  const O = K("permission"), L = f([["arrivalTime", ["parse-time", "{y}-{m}-{d}"]]]), W = f([...ne, ...L.value]), z = f(), { CRUD: F, crud: b, detail: r } = se(), u = f({ classifyName: void 0, specification: void 0 }), S = f("purchase"), k = f([]);
  function v() {
    const c = [];
    JSON.parse(JSON.stringify(r.detailList)).forEach((m) => {
      (!u.value.classifyName || m.classifyName.includes(u.value.classifyName)) && (!u.value.specification || m.specification.includes(u.value.specification)) && c.push(m);
    }), k.value = c;
  }
  const { maxHeight: D } = re({ mainBox: ".subscription-list-record-detail", extraBox: [".el-drawer__header", ".table-header", ".table-remark"], wrapperBox: [".el-drawer__body"], clientHRepMainH: true, minHeight: 300, extraHeight: 10 }, () => I(() => !b.detailLoading)), y = I(() => !!(r.materialType & pe.MANUFACTURED.V)), M = f(false), U = f({});
  F.HOOK.beforeDetailLoaded = async (c, l) => {
    var m;
    y.value ? (l.detailList.forEach((n) => {
      n.totalLength = T(g(n.totalLength, h.LENGTH_DP), h.LENGTH, "m"), n.totalWeight = T(g(n.totalWeight, h.WEIGHT_DP), h.WEIGHT, "kg"), n.weight = T(g(n.weight, h.WEIGHT_DP), h.WEIGHT, "kg"), n.totalArea = T(g(n.totalArea, h.AREA_DP), h.AREA, "m²");
    }), l.projectNames = [], (m = l.projectInfos) == null || m.forEach((n) => {
      l.projectNames.push(B(n));
    }), l.projectNames = l.projectNames.join(",")) : (u.value = {}, await ce(l.detailList), l.detailList.forEach((n) => {
      n.basicClass === me.STEEL_COIL.V && (n.measureUnit = "米", n.measurePrecision = 3), n.materialInventoryId ? n.requisitionMode = E.USE_INVENTORY.V : n.requisitionMode = E.PURCHASE.V;
    }), l.detailList = await ue(l.detailList, { toSmallest: false, toNum: false }, { mete: ["mete", "havePurchasedMete", "unPurchaseMete", "inboundMete"] }), k.value = JSON.parse(JSON.stringify(l.detailList)));
  };
  function C(c, l) {
    S.value = l, M.value = true, U.value = c;
  }
  function G(c) {
    return q(c, { props: [["quantity", 3], "mete", "havePurchasedMete", "unPurchaseMete"] });
  }
  function $(c) {
    return q(c, { props: [["quantity", 3], "totalWeight", "havePurchasedMete", "unPurchaseMete"] });
  }
  return (c, l) => {
    const m = te, n = x("print-table"), j = ae, J = x("table-cell-tag"), a = oe, P = le, A = x("common-table"), Y = x("common-drawer"), X = Q("permission");
    return _(), N(V, null, [e(Y, { ref_key: "drawerRef", ref: z, "before-close": o(b).cancelDetail, "content-loading": o(b).detailLoading, "show-close": true, visible: o(b).detailVisible, "custom-class": "subscription-list-record-detail", size: "80%", title: "申购详情" }, Z({ titleAfter: i(() => [p("div", Te, [e(m, { effect: "plain", size: "medium" }, { default: i(() => {
      var t;
      return [d("申购编号：" + s((t = o(r)) == null ? void 0 : t.serialNumber), 1)];
    }), _: 1 }), e(m, { effect: "plain", size: "medium", type: "success" }, { default: i(() => {
      var t;
      return [d("申购人：" + s((t = o(r)) == null ? void 0 : t.applicantName), 1)];
    }), _: 1 }), o(r).materialType & o(ye).MANUFACTURED.V ? (_(), R(m, { key: 0, effect: "plain", size: "medium", type: "danger" }, { default: i(() => {
      var t;
      return [d(" 项目：" + s((t = o(r)) == null ? void 0 : t.projectNames), 1)];
    }), _: 1 })) : H("", true)])]), titleRight: i(() => {
      var t, w;
      return [e(xe, { fn: o(Ne), params: { id: o(r).id }, size: "small" }, { default: i(() => l[4] || (l[4] = [d(" 申购采购跟踪下载 ")])), _: 1, __: [4] }, 8, ["fn", "params"]), p("div", ke, [ee(e(n, { "api-key": y.value ? "scmManufRequisitionsDetail" : "scmRequisitionsDetail", params: (t = o(r)) == null ? void 0 : t.id, size: "mini", type: "warning" }, null, 8, ["api-key", "params"]), [[X, (w = o(O)) == null ? void 0 : w.print]])])];
    }), _: 2 }, [o(de)(o(r)) ? { name: "content", fn: i(() => [y.value ? H("", true) : (_(), N("div", Me, [e(j, { modelValue: u.value.classifyName, "onUpdate:modelValue": l[0] || (l[0] = (t) => u.value.classifyName = t), modelModifiers: { trim: true }, class: "filter-item", clearable: "", placeholder: "物料种类", size: "default", style: { width: "200px" }, onBlur: v, onClear: v }, null, 8, ["modelValue"]), e(j, { modelValue: u.value.specification, "onUpdate:modelValue": l[1] || (l[1] = (t) => u.value.specification = t), modelModifiers: { trim: true }, class: "filter-item", clearable: "", placeholder: "规格", size: "default", style: { width: "200px", "margin-left": "10px" }, onBlur: v, onClear: v }, null, 8, ["modelValue"])])), y.value ? (_(), R(A, { key: 2, data: o(r).detailList, "data-format": L.value, "max-height": o(D), "summary-method": $, "show-summary": "" }, { default: i(() => [e(a, { align: "center", fixed: "left", label: "序号", type: "index", width: "55" }), o(r).finishedProductType === o(_e).STRUC_MANUFACTURED.V ? (_(), N(V, { key: 0 }, [e(a, { align: "center", label: "单体", "min-width": "120px", prop: "monomer.name", "show-overflow-tooltip": "" }), e(a, { align: "center", label: "区域", "min-width": "120px", prop: "area.name", "show-overflow-tooltip": "" }), e(a, { align: "center", label: "名称", "min-width": "100px", prop: "manufacturedName", "show-overflow-tooltip": "" }), e(a, { align: "center", label: "编号", "min-width": "100px", prop: "manufacturedSn", "show-overflow-tooltip": "" }), e(a, { align: "center", label: "规格", "min-width": "140px", prop: "specification", "show-overflow-tooltip": "" }), e(a, { align: "center", label: "长度（mm）", "min-width": "120px", prop: "length", "show-overflow-tooltip": "" }), e(a, { align: "center", label: "材质", prop: "material", "show-overflow-tooltip": "" }), e(a, { align: "center", label: "数量", "min-width": "100px", "show-overflow-tooltip": "" }, { default: i(({ row: { sourceRow: t } }) => [d(s(t.quantity), 1)]), _: 1 }), e(a, { align: "center", label: "单重（kg）", "min-width": "120px", "show-overflow-tooltip": "" }, { default: i(({ row: { sourceRow: t } }) => [p("span", null, s(o(g)(t.weight, 2)), 1)]), _: 1 }), e(a, { align: "center", label: "总重（kg）", "min-width": "120px", prop: "totalWeight", "show-overflow-tooltip": "" }, { default: i(({ row: { sourceRow: t } }) => [p("span", null, s(t.totalWeight), 1)]), _: 1 })], 64)) : (_(), N(V, { key: 1 }, [e(a, { align: "center", label: "类型", "min-width": "120px", prop: "category", "show-overflow-tooltip": "" }, { default: i(({ row: { sourceRow: t } }) => [d(s(o(ge).VL[t.manufacturedType]), 1)]), _: 1 }), e(a, { align: "center", label: "编号", "min-width": "120px", prop: "manufacturedSn", "show-overflow-tooltip": "" }), e(a, { align: "center", label: "名称", "min-width": "100px", prop: "manufacturedName", "show-overflow-tooltip": "" }), e(a, { align: "center", label: "规格", "min-width": "140px", prop: "specification", "show-overflow-tooltip": "" }), e(a, { align: "center", label: "有效宽度", "min-width": "100px", prop: "width", "show-overflow-tooltip": "" }), e(a, { align: "center", label: "厚度（mm）", "min-width": "120px", prop: "thickness", "show-overflow-tooltip": "" }), e(a, { align: "center", label: "品牌", prop: "brand", "show-overflow-tooltip": "" }), e(a, { align: "center", label: "颜色", prop: "color", "show-overflow-tooltip": "" }), e(a, { align: "center", label: "材质", prop: "material", "show-overflow-tooltip": "" }), e(a, { align: "center", label: "单长（mm）", "min-width": "120px", prop: "length", "show-overflow-tooltip": "" }), e(a, { align: "center", label: "数量（张）", "min-width": "100px", prop: "quantity", "show-overflow-tooltip": "" }), e(a, { align: "center", label: "总长（m）", "min-width": "120px", prop: "totalLength", "show-overflow-tooltip": "" }), e(a, { align: "center", label: "总面积（m²）", "min-width": "120px", prop: "totalArea", "show-overflow-tooltip": "" }), e(a, { align: "center", label: "总重（kg）", "min-width": "150px", prop: "totalWeight", "show-overflow-tooltip": "" })], 64)), e(a, { align: "center", label: "已采购量", "min-width": "100px", prop: "havePurchasedMete", "show-overflow-tooltip": "" }, { default: i(({ row: t }) => [e(P, { underline: false, onClick: (w) => C(t, "purchase") }, { default: i(() => [p("span", Re, s(t.havePurchasedMete), 1)]), _: 2 }, 1032, ["onClick"])]), _: 1 }), e(a, { align: "center", label: "未采购量", "min-width": "100px", prop: "unPurchaseMete", "show-overflow-tooltip": "" }, { default: i(({ row: t }) => [d(s(t.unPurchaseMete), 1)]), _: 1 }), e(a, { align: "center", label: "到厂日期", "min-width": "120px", prop: "arrivalTime", "show-overflow-tooltip": "" })]), _: 1 }, 8, ["data", "data-format", "max-height"])) : (_(), R(A, { key: 1, data: k.value, "data-format": W.value, "max-height": o(D), "summary-method": G, "show-summary": "" }, { default: i(() => [e(a, { align: "center", fixed: "left", label: "序号", type: "index", width: "55" }, { default: i(({ row: t, $index: w }) => [e(J, { name: o(E).USE_INVENTORY.L, show: t.requisitionMode === o(E).USE_INVENTORY.V, color: "#e6a23c" }, null, 8, ["name", "show"]), p("span", null, s(w + 1), 1)]), _: 1 }), e(fe, { isSerialNumber: false, showIndex: false, fixed: "left" }), e(he), e(a, { align: "left", label: "项目", "min-width": "200px", prop: "project" }, { default: i(({ row: { sourceRow: t } }) => [d(s(o(B)(t.project)), 1)]), _: 1 }), e(we), e(a, { align: "center", label: "实际入库量", "min-width": "100px", prop: "inboundMete", "show-overflow-tooltip": "" }, { default: i(({ row: t }) => [e(P, { underline: false, onClick: (w) => C(t, "inbound") }, { default: i(() => [p("span", Ce, s(t.inboundMete), 1)]), _: 2 }, 1032, ["onClick"])]), _: 1 }), e(a, { align: "center", label: "已采购量", "min-width": "100px", prop: "havePurchasedMete", "show-overflow-tooltip": "" }, { default: i(({ row: t }) => [e(P, { underline: false, onClick: (w) => C(t, "purchase") }, { default: i(() => [p("span", Pe, s(t.havePurchasedMete), 1)]), _: 2 }, 1032, ["onClick"])]), _: 1 }), e(a, { align: "center", label: "未采购量", "min-width": "100px", prop: "unPurchaseMete", "show-overflow-tooltip": "" }, { default: i(({ row: t }) => [d(s(t.unPurchaseMete), 1)]), _: 1 }), e(a, { align: "center", label: "到厂日期", prop: "arrivalTime", "show-overflow-tooltip": "", width: "120px" })]), _: 1 }, 8, ["data", "data-format", "max-height"])), p("div", Ve, [l[5] || (l[5] = p("span", null, "备注", -1)), p("span", null, [p("span", null, s(o(r).remark), 1)])]), e(be, { files: o(r).attachments, "onUpdate:files": l[2] || (l[2] = (t) => o(r).attachments = t), "file-classify": o(ve).PURCHASE_ORDER_ATT.V, showView: true, uploadable: false, "empty-text": "暂未上传附件", "show-download": "", style: { "margin-top": "10px" } }, null, 8, ["files", "file-classify"])]), key: "0" } : void 0]), 1032, ["before-close", "content-loading", "visible"]), e(Ee, { visible: M.value, "onUpdate:visible": l[3] || (l[3] = (t) => M.value = t), info: U.value, showType: S.value }, null, 8, ["visible", "info", "showType"])], 64);
  };
} }, je = ie(Le, [["__scopeId", "data-v-079291ce"]]);
export {
  je as default
};
