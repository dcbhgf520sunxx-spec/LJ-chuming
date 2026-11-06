import { ref as C } from "vue";
import { watch as le } from "vue";
import { computed as oe } from "vue";
import { resolveComponent as v } from "vue";
import { openBlock as f } from "vue";
import { createBlock as y } from "vue";
import { withCtx as n } from "vue";
import { createVNode as e } from "vue";
import { createTextVNode as b } from "vue";
import { unref as l } from "vue";
import { createElementVNode as w } from "vue";
import { toDisplayString as c } from "vue";
import R from "moment";
import { createElementBlock as P } from "vue";
import { Fragment as q } from "vue";
import { createCommentVNode as ie } from "vue";
import { ElPopconfirm as ne } from "element-plus";
import { ElTableColumn as se } from "element-plus";
import { ElDatePicker as re } from "element-plus";
import { ElInput as pe } from "element-plus";
import { ElForm as ue } from "element-plus";
import { _ as me, jX as ce, u as de, tC as fe, o as we, jl as he, wb as V, v0 as B, uP as O, wt as ge, wu as be, wv as _e, wc as F, jG as ve, jH as ye, i as xe, iX as Te, T as Ce, R as Re, S as Ve, aw as Ee, ba as Se } from "../../../../../../shared/runtime.js";
import Ne from "./common-footer.vue.js";
const Me = { class: "table-remark" }, Ue = { style: { "padding-bottom": "40px" } }, ke = { __name: "confirm-dialog", props: { modelValue: { type: Boolean, default: false }, isManufactured: { type: Boolean, default: false } }, emits: ["saveSuccess", "update:modelValue", "manuf-del", "manuf-del-all"], setup(E, { emit: I }) {
  const x = I, d = E, h = C(), S = C([]), j = C([...ce]), { visible: T, handleClose: N } = de({ emit: x, props: d }), { cu: m, form: s, FORM: _ } = fe(), H = { arrivalTime: [{ required: true, message: "请选择需求完成日期", trigger: "change" }] }, L = /* @__PURE__ */ new Map([["arrivalTime", "同上"]]), { tableValidate: z, cleanUpData: W, wrongCellMask: M } = Ee({ rules: H, ditto: L }), { maxHeight: U } = we({ mainBox: ".requisitions-application-preview", extraBox: [".el-dialog__header", ".footer", ".table-remark"], wrapperBox: [".el-dialog__body"], navbar: false, clientHRepMainH: true, minHeight: 300, extraHeight: 10 }, T);
  function G({ row: t, rowIndex: o }) {
    var r, g;
    if ((g = (r = m == null ? void 0 : m.submitResult) == null ? void 0 : r.data) != null && g.includes(t.classifyId)) return { backgroundColor: "#ffdede" };
  }
  le(() => d.modelValue, (t) => {
    S.value = [], h.value = void 0, t && Y(), d.isManufactured && s.list.forEach((o, r) => {
      r !== 0 && (o.arrivalTime = "同上");
    });
  }, { immediate: true }), m.submitFormFormat = async (t) => (t.list = W(t.list), t.attachmentIds = t.attachments ? t.attachments.map((o) => o.id) : void 0, d.isManufactured ? t.list = t.list.map((o) => ({ artifactEnclosureId: t.finishedProductType === V.STRUC_MANUFACTURED.V ? o.productId : o.id, basicClass: t.finishedProductType === V.STRUC_MANUFACTURED.V ? B.STRUC_MANUFACTURED.V : B.ENCL_MANUFACTURED.V, arrivalTime: o.arrivalTime, quantity: o.quantity })) : t.list = await he(t.list, { toSmallest: true, toNum: true }), t), _.HOOK.beforeSubmit = async () => {
    s.dataStatus === O.PASSED.V && (m.api = ge), s.dataStatus === O.UNDER_APPROVAL.V && (m.api = be);
    const { validResult: t } = z(s.list);
    if (!t) return !d.isManufactured && h.value && (h.value = void 0), false;
  }, _.HOOK.afterSubmit = async () => {
    N();
  };
  async function Y() {
    const t = await _e() || [];
    S.value = t;
  }
  function $(t, o, r) {
    r !== 0 && !t && (o.arrivalTime = "同上");
  }
  const k = oe(() => d.isManufactured ? s.list.map((t) => t) : s.list.filter((t) => {
    let o = true;
    return h.value && t.requisitionMode !== h.value && (o = false), o;
  }));
  function K(t, o) {
    x("manuf-del", { id: t.id, quantity: t.quantity }, t, o);
  }
  function X() {
    x("manuf-del-all");
  }
  function J(t) {
    return Se(t, { props: ["quantity", "totalWeight"] });
  }
  return (t, o) => {
    const r = v("common-button"), g = ne, Q = v("table-cell-tag"), a = se, A = v("common-table"), Z = re, ee = pe, te = ue, ae = v("common-drawer");
    return f(), y(ae, { "before-close": l(N), "show-close": true, visible: l(T), "custom-class": "requisitions-application-preview", fullscreen: "", size: "80%", title: "材料申购汇总" }, { titleRight: n(() => [e(g, { title: "你确定要清空数据吗?", onConfirm: X }, { reference: n(() => [e(r, { class: "filter-item", size: "default", type: "danger" }, { default: n(() => o[2] || (o[2] = [b(" 一键清空 ")])), _: 1, __: [2] })]), _: 1 })]), content: n(() => [l(T) ? (f(), y(te, { key: 0, ref: "formRef", disabled: l(m).status.edit === l(_).STATUS.PROCESSING, model: l(s) }, { default: n(() => [E.isManufactured ? (f(), y(A, { key: 1, "cell-class-name": l(M), data: k.value, "max-height": l(U) - 170, "summary-method": J, "show-summary": "" }, { default: n(() => [e(a, { align: "center", fixed: "left", label: "序号", type: "index", width: "55" }), l(s).finishedProductType === l(V).STRUC_MANUFACTURED.V ? (f(), P(q, { key: 0 }, [e(a, { align: "center", label: "单体", "min-width": "120px", prop: "monomer.name", "show-overflow-tooltip": "" }), e(a, { align: "center", label: "区域", "min-width": "120px", prop: "area.name", "show-overflow-tooltip": "" }), e(a, { align: "center", label: "名称", "min-width": "100px", prop: "name", "show-overflow-tooltip": "" }), e(a, { align: "center", label: "编号", "min-width": "100px", prop: "serialNumber", "show-overflow-tooltip": "" }), e(a, { align: "center", label: "规格", "min-width": "140px", prop: "specification", "show-overflow-tooltip": "" }), e(a, { align: "center", label: "长度（mm）", prop: "length", "show-overflow-tooltip": "" }), e(a, { align: "center", label: "材质", prop: "material", "show-overflow-tooltip": "" }), e(a, { align: "center", label: "数量", "min-width": "100px", prop: "quantity", "show-overflow-tooltip": "" }, { default: n(({ row: { sourceRow: i } }) => [b(c(i.quantity), 1)]), _: 1 }), e(a, { align: "center", label: "单重（kg）", prop: "weight", "show-overflow-tooltip": "" }, { default: n(({ row: { sourceRow: i } }) => [w("span", null, c(l(Te)(i.weight, 2)), 1)]), _: 1 }), e(a, { align: "center", label: "总重（kg）", prop: "totalWeight", "show-overflow-tooltip": "" }, { default: n(({ row: { sourceRow: i } }) => [w("span", null, c(i.totalWeight), 1)]), _: 1 })], 64)) : (f(), P(q, { key: 1 }, [e(a, { align: "center", label: "类型", "min-width": "120px", prop: "category", "show-overflow-tooltip": "" }, { default: n(({ row: { sourceRow: i } }) => [b(c(l(Ce).VL[i.category]), 1)]), _: 1 }), e(a, { align: "center", label: "编号", "min-width": "120px", prop: "serialNumber", "show-overflow-tooltip": "" }), e(a, { align: "center", label: "名称", "min-width": "100px", prop: "name", "show-overflow-tooltip": "" }), e(a, { align: "center", label: "规格", "min-width": "140px", prop: "specification", "show-overflow-tooltip": "" }), e(a, { align: "center", label: "有效宽度", "min-width": "100px", prop: "width", "show-overflow-tooltip": "" }), e(a, { align: "center", label: "厚度（mm）", "min-width": "120px", prop: "thickness", "show-overflow-tooltip": "" }), e(a, { align: "center", label: "品牌", prop: "brand", "show-overflow-tooltip": "" }), e(a, { align: "center", label: "颜色", prop: "color", "show-overflow-tooltip": "" }), e(a, { align: "center", label: "材质", prop: "material", "show-overflow-tooltip": "" }), e(a, { align: "center", label: "单长（mm）", "min-width": "120px", prop: "length", "show-overflow-tooltip": "" }), e(a, { align: "center", label: "数量（张）", "min-width": "100px", prop: "quantity", "show-overflow-tooltip": "" }), e(a, { align: "center", label: "总长（m）", "min-width": "120px", prop: "totalLength", "show-overflow-tooltip": "" }), e(a, { align: "center", label: "总面积（m²）", "min-width": "120px", prop: "totalArea", "show-overflow-tooltip": "" }), e(a, { align: "center", label: "总重（kg）", "min-width": "120px", prop: "totalWeight", "show-overflow-tooltip": "" })], 64)), e(a, { align: "center", label: "到厂日期", prop: "arrivalTime", width: "160px" }, { default: n(({ row: { sourceRow: i }, $index: p }) => [e(Z, { modelValue: i.arrivalTime, "onUpdate:modelValue": (u) => i.arrivalTime = u, disabled: l(m).status.edit === l(_).STATUS.PROCESSING, disabledDate: (u) => l(R)(u).valueOf() < l(R)().subtract(1, "days").valueOf(), placeholder: p === 0 ? "选择日期" : "同上", size: "default", style: { width: "100%" }, type: "date", "value-format": "x", onChange: (u) => $(u, i, p) }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "disabledDate", "placeholder", "onChange"])]), _: 1 }), e(a, { align: "center", fixed: "right", label: "操作", width: "80" }, { default: n(({ row: { sourceRow: i }, $index: p }) => [e(g, { title: "你确定要删除该数据吗?", onConfirm: (u) => K(i, p) }, { reference: n(() => [e(r, { icon: "el-icon-delete", size: "default", type: "danger" })]), _: 2 }, 1032, ["onConfirm"])]), _: 1 })]), _: 1 }, 8, ["cell-class-name", "data", "max-height"])) : (f(), y(A, { key: 0, "cell-class-name": l(M), data: k.value, "data-format": j.value, "max-height": l(U), "row-style": G, stripe: false }, { default: n(() => [e(a, { align: "center", label: "序号", type: "index", width: "55" }, { default: n(({ row: i, $index: p }) => [e(Q, { name: l(F).USE_INVENTORY.L, show: i.requisitionMode === l(F).USE_INVENTORY.V, color: "#e6a23c" }, null, 8, ["name", "show"]), w("span", null, c(p + 1), 1)]), _: 1 }), e(ve, { showIndex: false }), e(ye, { "show-measure-unit": false, "show-quantity": false }), e(a, { align: "left", label: "项目", "min-width": "200px", prop: "project" }, { default: n(({ row: { sourceRow: i } }) => {
      var p, u, D;
      return [b(c(l(xe)((p = i.project) == null ? void 0 : p.shortName) ? `${(u = i.project) == null ? void 0 : u.serialNumber} ${(D = i.project) == null ? void 0 : D.shortName}` : "-"), 1)];
    }), _: 1 }), e(a, { align: "center", label: "到厂日期", width: "160px" }, { default: n(({ row: { sourceRow: i } }) => [b(c(l(R)(Number(i.arrivalTime)).format("yyyy-MM-DD")), 1)]), _: 1 })]), _: 1 }, 8, ["cell-class-name", "data", "data-format", "max-height"])), w("div", Me, [o[3] || (o[3] = w("span", null, "备注", -1)), e(ee, { modelValue: l(s).remark, "onUpdate:modelValue": o[0] || (o[0] = (i) => l(s).remark = i), rows: 2, class: "remark input-border-none", maxlength: "200", placeholder: "请填写申购备注", "show-word-limit": "", type: "textarea" }, null, 8, ["modelValue"])]), w("div", Ue, [e(Re, { files: l(s).attachments, "onUpdate:files": o[1] || (o[1] = (i) => l(s).attachments = i), "file-classify": l(Ve).NORMAL.V, showView: true, class: "el-form-item-15", "empty-text": "暂未上传附件", "show-download": "", style: { "margin-top": "10px" } }, null, 8, ["files", "file-classify"])])]), _: 1 }, 8, ["disabled", "model"])) : ie("", true), e(Ne, { "show-total": false, class: "footer", "is-submit": "" })]), _: 1 }, 8, ["before-close", "visible"]);
  };
} }, qe = me(ke, [["__scopeId", "data-v-64899b00"]]);
export {
  qe as default
};
