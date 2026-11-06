import { ref as c } from "vue";
import { watch as L } from "vue";
import { computed as R } from "vue";
import { resolveComponent as h } from "vue";
import { resolveDirective as B } from "vue";
import { openBlock as M } from "vue";
import { createBlock as z } from "vue";
import { withCtx as n } from "vue";
import { createVNode as l } from "vue";
import { createTextVNode as S } from "vue";
import { createElementVNode as i } from "vue";
import { withDirectives as $ } from "vue";
import { toDisplayString as v } from "vue";
import { unref as U } from "vue";
import { isRef as ie } from "vue";
import { ElMessage as ue } from "element-plus";
import { ElFormItem as de } from "element-plus";
import { ElCheckbox as ce } from "element-plus";
import { ElInput as me } from "element-plus";
import { ElTableColumn as pe } from "element-plus";
import { ElForm as fe } from "element-plus";
import { vLoading as be } from "element-plus";
import { l as k, _ as _e, xC as ye, jX as he, u as ve, jY as we, o as ge, am as xe, cO as Re, jl as Ve, cS as Ce, r8 as Te, r9 as Ue, aR as ke, k4 as je, jG as Ee, sO as Pe, k5 as Ie, k6 as Qe, xD as Oe, xG as Le } from "../../../../../../shared/runtime.js";
function Be(s) {
  return k({ module: "wms", url: "transfer/party-a/borrow", method: "get", params: s });
}
function Me(s) {
  return k({ module: "wms", url: "transfer/party-a/borrow/return", method: "put", data: s });
}
function ze(s) {
  return k({ module: "wms", url: `transfer/party-a/borrow/${s}/return-mat-list`, method: "get" });
}
const We = { get: Be };
const Se = { class: "form-header" }, $e = { class: "flex-rbc" }, Fe = { class: "returned-number" }, He = { class: "flex-rbc" }, Je = { style: { flex: "none", "margin-left": "10px" } }, qe = { __name: "return-material", props: { visible: { type: Boolean, require: true }, basicClass: { type: Number }, detail: { type: Object, default: () => ({}) } }, emits: ["success", "update:visible"], setup(s, { emit: F }) {
  const { realTimeValidate: H } = ye(), j = F, u = s, p = { PUBLIC: { L: "公共库", K: "PUBLIC", V: 1 }, CUR_PROJECT: { L: "借用项目", K: "CUR_PROJECT", V: 2 }, OTHER_PROJECT: { L: "其它项目", K: "OTHER_PROJECT", V: 3 } }, J = { workshopId: [{ required: true, message: "请选择归还车间", trigger: "change" }], warehouseId: [{ required: true, message: "请选择归还仓库", trigger: "change" }], realTime: [{ validator: H, message: "请选择实际归还时间", trigger: "change" }] }, q = c([...he, ["corReturnedQuantity", ["to-fixed", "outboundUnitPrecision"]], ["corQuantity", ["to-fixed", "outboundUnitPrecision"]], ["project", ["parse-project", { onlyShortName: true }]]]), b = c(), w = c([]), _ = c([]), f = c([]), V = c(false), d = c({ type: p.CUR_PROJECT.V, hasReturnedQuantity: false }), E = c([]), m = c({ list: [] }), C = c(false), { visible: g, handleClose: P } = ve({ emit: j, props: u, field: "visible", showHook: A }), { partyABorrowReturnCfg: T } = we();
  L(T, () => {
    T.value && T.value.boolReturnByOtherProject ? E.value = [] : E.value = [p.OTHER_PROJECT.V];
  }, { immediate: true, deep: true });
  const { maxHeight: N } = ge({ mainBox: ".wms-borrow-return-handling", extraBox: [".el-dialog__header", ".form-header"], wrapperBox: [".el-dialog__body"], clientHRepMainH: true, navbar: false, minHeight: 350 }, g), x = R(() => u.detail.basicClass), I = R(() => {
    const o = d.value.hasReturnedQuantity ? f.value : _.value;
    return d.value.type ? d.value.type === p.PUBLIC.V ? o.filter((e) => !e.project || !e.project.id) : d.value.type === p.CUR_PROJECT.V ? o.filter((e) => e.project && u.detail.borrowProject && e.project.id === u.detail.borrowProject.id) : d.value.type === p.OTHER_PROJECT.V ? o.filter((e) => e.project && u.detail.borrowProject && e.project.id && e.project.id !== u.detail.borrowProject.id) : o : o;
  }), Q = R(() => f.value.reduce((o, e) => o + (e.returnedQuantity || 0), 0)), D = R(() => u.basicClass === xe.STEEL_PLATE.V ? { minRows: 2, maxRows: 2 } : { minRows: 1, maxRows: 1 });
  L(() => u.detail, (o) => {
    O(), K(o.id);
  }, { immediate: true });
  function O() {
    var o, e, t, r;
    m.value = { workshopId: (e = (o = u.detail) == null ? void 0 : o.borrowWorkShop) == null ? void 0 : e.id, warehouseId: (r = (t = u.detail) == null ? void 0 : t.borrowWareHouse) == null ? void 0 : r.id, list: [] }, b.value && b.value.resetFields(), _.value = [], f.value = [], w.value = [], d.value.type = p.CUR_PROJECT.V, d.value.hasReturnedQuantity = false;
  }
  async function K(o) {
    if (_.value = [], !!o) try {
      V.value = true;
      const { content: e = [] } = await ze(o);
      await Re(e), _.value = await Ve(e, { toSmallest: false, toNum: false }), _.value.forEach((t) => {
        t.operableQuantity = t.quantity - t.frozenQuantity, t.operableMete = t.mete - t.frozenMete, t.realTime = t.realTime || (/* @__PURE__ */ new Date()).getTime(), t.outboundUnitType === Ce.MEASURE.V ? (t.corQuantity = t.quantity, t.corFrozenQuantity = t.frozenQuantity, t.corOperableQuantity = t.operableQuantity) : (t.corQuantity = t.mete, t.corFrozenQuantity = t.frozenMete, t.corOperableQuantity = t.operableMete);
      });
    } catch (e) {
      console.log("加载可归还物料列表", e);
    } finally {
      V.value = false;
    }
  }
  function W(o, e) {
    const t = f.value.findIndex((r) => r.id === e.id);
    t > -1 && !o && f.value.splice(t, 1), t === -1 && o && f.value.push(e);
  }
  function A() {
    b.value && b.value.clearValidate();
  }
  async function G() {
    try {
      if (C.value = true, !await b.value.validate()) return;
      const e = { id: u.detail.id, workshopId: m.value.workshopId, warehouseId: m.value.warehouseId, list: f.value.map((t) => ({ id: t.id, quantity: t.returnedQuantity, outboundUnit: t.outboundUnit, realTime: t.realTime, outboundUnitPrecision: t.outboundUnitPrecision, outboundUnitType: t.outboundUnitType, remark: t.remark })) };
      if (await Le(e.list, { unitField: "outboundUnit", unitPrecisionField: "outboundUnitPrecision", fields: ["quantity"], toSmallest: true, toNum: true }), e.list.length === 0) {
        ue.warning("请填写数据");
        return;
      }
      await Me(e), j("success"), P(), setTimeout(() => {
        O();
      }, 0);
    } catch (o) {
      console.log("归还办理", o);
    } finally {
      C.value = false;
    }
  }
  return (o, e) => {
    const t = h("common-button"), r = de, X = h("common-radio-button"), Y = ce, Z = me, ee = h("common-input-number"), te = pe, ae = h("common-table"), le = fe, oe = h("common-dialog"), ne = B("parse-project"), se = B("empty-text"), re = be;
    return M(), z(oe, { title: "归还办理", modelValue: U(g), "onUpdate:modelValue": e[5] || (e[5] = (a) => ie(g) ? g.value = a : null), width: "90%", "before-close": U(P), "show-close": true, "custom-class": "wms-borrow-return-handling", top: "10vh" }, { titleRight: n(() => [l(t, { loading: C.value, disabled: !Q.value, size: "default", type: "primary", onClick: G }, { default: n(() => e[6] || (e[6] = [S(" 提 交 ")])), _: 1, __: [6] }, 8, ["loading", "disabled"])]), default: n(() => [l(le, { ref_key: "formRef", ref: b, class: "form", model: m.value, rules: J, size: "default", "label-position": "right", inline: "", "label-width": "70px" }, { default: n(() => [i("div", Se, [l(r, { label: "归还项目", prop: "projectId" }, { default: n(() => [$(i("span", null, null, 512), [[ne, { project: s.detail.project }], [se]])]), _: 1 }), l(r, { label: "仓库", prop: "workshopId" }, { default: n(() => [l(Te, { modelValue: m.value.workshopId, "onUpdate:modelValue": e[0] || (e[0] = (a) => m.value.workshopId = a), placeholder: "仓库", class: "input-underline", style: { width: "200px" } }, null, 8, ["modelValue"])]), _: 1 }), l(r, { label: "存储位置", prop: "warehouseId", "label-width": "130px" }, { default: n(() => [l(Ue, { modelValue: m.value.warehouseId, "onUpdate:modelValue": e[1] || (e[1] = (a) => m.value.warehouseId = a), "workshop-id": m.value.workshopId, "basic-class": x.value, placeholder: "存储位置", class: "input-underline", style: { width: "200px" } }, null, 8, ["modelValue", "workshop-id", "basic-class"])]), _: 1 }), e[7] || (e[7] = i("br", null, null, -1)), i("div", $e, [l(r, { label: "类型" }, { default: n(() => [l(X, { type: "enum", modelValue: d.value.type, "onUpdate:modelValue": e[2] || (e[2] = (a) => d.value.type = a), options: p, unshowVal: [p.OTHER_PROJECT.V], "show-option-all": "", clearable: "" }, null, 8, ["modelValue", "unshowVal"])]), _: 1 }), i("div", null, [l(r, { label: "只显示填写归还数量的材料", "label-width": "180px" }, { default: n(() => [l(Y, { modelValue: d.value.hasReturnedQuantity, "onUpdate:modelValue": e[3] || (e[3] = (a) => d.value.hasReturnedQuantity = a), size: "default" }, null, 8, ["modelValue"])]), _: 1 }), l(r, { label: "本次归还统计", "label-width": "100px" }, { default: n(() => [i("span", Fe, v(Q.value), 1), i("span", null, v(` / ${s.detail.corPendingQuantity} ${s.detail.outboundUnit}`), 1)]), _: 1 }), l(r, { label: "审核中的数量", "label-width": "100px" }, { default: n(() => [i("span", null, v(`${s.detail.corUnderReviewQuantity} ${s.detail.outboundUnit}`), 1)]), _: 1 })])])]), $((M(), z(ae, { ref: "tableRef", data: I.value, "data-format": q.value, "max-height": U(N), "default-expand-all": false, "expand-row-keys": w.value, "row-key": "id" }, { default: n(() => [l(ke, { data: I.value, "expand-row-keys": w.value, "onUpdate:expandRowKeys": e[4] || (e[4] = (a) => w.value = a), "row-key": "id", fixed: "left" }, { default: n(({ row: a }) => [l(je, { "basic-class": a.basicClass, row: a }, { default: n(() => [i("p", null, [e[8] || (e[8] = S(" 项目：")), i("span", null, v(a.projectFullName), 1)]), l(Z, { modelValue: a.sourceRow.remark, "onUpdate:modelValue": (y) => a.sourceRow.remark = y, autosize: D.value, type: "textarea", placeholder: "备注", maxlength: "200", "show-word-limit": "", style: { "max-width": "400px" } }, null, 8, ["modelValue", "onUpdate:modelValue", "autosize"])]), _: 2 }, 1032, ["basic-class", "row"])]), _: 1 }, 8, ["data", "expand-row-keys"]), l(Ee, { "basic-class": x.value, fixed: "left" }, null, 8, ["basic-class"]), l(Pe, { "basic-class": x.value }, null, 8, ["basic-class"]), l(Ie, { "basic-class": x.value, "show-batch-no": false }, null, 8, ["basic-class"]), l(Qe, { "show-project": "" }), l(te, { label: "归还数量", width: "170px", align: "center", fixed: "right" }, { default: n(({ row: { sourceRow: a } }) => [i("span", He, [l(ee, { modelValue: a.returnedQuantity, "onUpdate:modelValue": (y) => a.returnedQuantity = y, min: 0, precision: a.outboundUnitPrecision, max: a.corOperableQuantity, "controls-position": "right", onChange: (y) => W(y, a) }, null, 8, ["modelValue", "onUpdate:modelValue", "precision", "max", "onChange"]), i("span", Je, v(a.outboundUnit), 1)])]), _: 1 }), l(Oe, { label: "实际归还时间", showSourceRow: "" })]), _: 1 }, 8, ["data", "data-format", "max-height", "expand-row-keys"])), [[re, V.value]])]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, Ne = _e(qe, [["__scopeId", "data-v-4dd4e827"]]), Ae = Object.freeze(Object.defineProperty({ __proto__: null, default: Ne }, Symbol.toStringTag, { value: "Module" }));
export {
  Ae as a,
  We as c,
  Ne as r
};
