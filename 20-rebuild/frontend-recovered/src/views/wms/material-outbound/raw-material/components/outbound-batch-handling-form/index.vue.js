import { computed as E } from "vue";
import { ref as _ } from "vue";
import { watch as W } from "vue";
import { nextTick as Ie } from "vue";
import { watchEffect as ve } from "vue";
import { resolveComponent as w } from "vue";
import { resolveDirective as Ve } from "vue";
import { openBlock as O } from "vue";
import { createBlock as A } from "vue";
import { withCtx as n } from "vue";
import { createVNode as o } from "vue";
import { createTextVNode as T } from "vue";
import { createElementVNode as b } from "vue";
import { withDirectives as Ee } from "vue";
import { createElementBlock as $ } from "vue";
import { Fragment as K } from "vue";
import { unref as p } from "vue";
import { createCommentVNode as G } from "vue";
import { toDisplayString as J } from "vue";
import { isRef as Oe } from "vue";
import { ElMessage as Q } from "element-plus";
import { ElFormItem as ke } from "element-plus";
import { ElInput as Ce } from "element-plus";
import { ElTableColumn as Te } from "element-plus";
import { ElTag as Ue } from "element-plus";
import { ElForm as Re } from "element-plus";
import { fg as Pe, cV as Me, sP as Ae, u as Qe, o as Se, jY as Le, pB as S, a$ as Be, am as x, b as Y, qS as L, cS as B, fv as Fe, cy as He, aR as Ne, k4 as ze, jG as qe, sO as De, k5 as We, k6 as $e, hV as Ke, j_ as I, aw as Ge, xG as Je, yJ as Ye, yK as Xe, yL as Ze, yM as et, yN as tt, yO as at } from "../../../../../../shared/runtime.js";
import { g as lt } from "../../../../../../modules/material-inventory-71cd4559.js";
import { _ as ot } from "../../../../../../modules/workshop-select-210dd661.js";
const st = { class: "form-header" }, nt = { class: "flex-rbc" }, it = { style: { flex: "none", "margin-left": "10px", "text-align": "left" } }, rt = { style: { display: "inline-block", width: "50px" } }, mt = { __name: "index", props: { visible: { type: Boolean, require: true }, projectWarehouseType: { type: Number }, projectId: { type: Number }, basicClass: { type: Number }, materialList: { type: Array, default: () => [] } }, emits: ["success", "update:visible"], setup(y, { emit: X }) {
  const F = X, u = y, { projectMap: Z, monomerMap: ee } = Pe(), te = { projectId: [{ required: true, message: "请选择出库项目", trigger: "change" }] }, ae = { workshopId: [{ required: true, message: "请选择出库车间", trigger: "change" }] }, H = /* @__PURE__ */ new Map([["workshopId", -1]]), { tableValidate: le, cleanUpData: oe, wrongCellMask: se } = Ge({ rules: ae, errorMsg: "请选择出库车间", ditto: H }), ne = E(() => {
    const e = { outboundAddress: [{ required: true, message: "请选择出库目的地", trigger: "change" }] };
    return u.basicClass & Me ? Object.assign(e, te) : e;
  }), j = _(), U = _([]), k = _([]), h = _([]), a = _({ list: [], recipientId: void 0 }), R = _(false), ie = _([...Ae, ["projectOperableQuantity", ["to-fixed-field", "measurePrecision"]], ["projectOperableMete", ["to-fixed-field", "accountingPrecision"]]]), { visible: v, handleClose: N } = Qe({ emit: F, props: u, field: "visible", showHook: be }), { maxHeight: re } = Se({ mainBox: ".wms-batch-outbound-handling", extraBox: [".el-dialog__header", ".form-header"], wrapperBox: [".el-dialog__body"], clientHRepMainH: true, navbar: false, minHeight: 350 }, v), { outboundCfg: ue } = Le(), C = E(() => u.projectWarehouseType === S.PUBLIC.V), z = E(() => C.value || ue.value.boolCanOutToOtherProject === true), de = E(() => {
    const e = {};
    return a.value.list.forEach((t) => {
      e[t.project.id] || (e[t.project.id] = t.project);
    }), Be(e);
  }), ce = E(() => u.basicClass === x.STEEL_PLATE.V ? { minRows: 2, maxRows: 2 } : { minRows: 1, maxRows: 1 });
  W([() => u.projectId, () => u.projectWarehouseType], ([e, t], [s]) => {
    t === S.PUBLIC.V && (a.value.projectId = void 0);
  }, { immediate: true });
  const pe = W(v, (e) => {
    e && (a.value.recipientId = void 0, Ie(() => {
      pe();
    }));
  }, { immediate: true });
  ve(() => {
    h.value = [], k.value = u.materialList.filter((t) => t.corOperableQuantity > 0);
    const e = JSON.parse(JSON.stringify(k.value));
    q(e), a.value.list = e, D();
  });
  function q(e) {
    if (!Y(e)) for (let t = 1; t < e.length; t++) {
      const s = e[t];
      H.forEach((i, g) => {
        Y(s[g]) && (s[g] = i);
      });
    }
  }
  function me() {
    h.value = [], a.value = { list: [] }, j.value && j.value.resetFields(), a.value.recipientId = void 0, a.value.outboundAddress = L.FACTORY.V;
  }
  function be() {
    j.value && j.value.clearValidate(), a.value.outboundAddress = L.FACTORY.V;
  }
  function fe() {
    a.value.list.forEach((e) => {
      e.batchOutboundQuantity = C.value ? e.corProjectOperableQuantity : e.corOperableQuantity;
    });
  }
  function ye() {
    a.value.list.forEach((e) => {
      e.batchOutboundQuantity = void 0;
    });
  }
  async function he() {
    try {
      if (R.value = true, !await j.value.validate()) return;
      const t = _e(u.basicClass), s = { projectId: a.value.projectId, monomerId: a.value.monomerId, areaId: a.value.areaId, recipientId: a.value.recipientId, outboundAddress: a.value.outboundAddress, list: [] };
      oe(a.value.list), a.value.list.forEach((d) => {
        d.batchOutboundQuantity && s.list.push({ id: d.id, workshopId: d.workshopId, quantity: d.batchOutboundQuantity, outboundUnit: d.outboundUnit, outboundUnitPrecision: d.outboundUnitPrecision, outboundUnitType: d.outboundUnitType, remark: d.remark });
      }), await Je(s.list, { unitField: "outboundUnit", unitPrecisionField: "outboundUnitPrecision", fields: ["quantity"], toSmallest: true, toNum: true });
      const { validResult: i, dealList: g } = le(s.list);
      if (i) s.list = g;
      else return i;
      if (s.list.length === 0) {
        Q.warning("请填写数据");
        return;
      }
      if (h.value = [], u.basicClass & I.STEEL.V || u.basicClass & I.MATERIAL.V || u.basicClass & I.OTHER.V) {
        const d = s.list.map((f) => f.id), { content: V } = await lt({ ids: d });
        s.list.map((f) => {
          const r = V == null ? void 0 : V.find((M) => M.id === f.id), P = f.outboundUnitType === B.MEASURE.V ? (r == null ? void 0 : r.quantity) - ((r == null ? void 0 : r.frozenQuantity) || 0) : (r == null ? void 0 : r.mete) - ((r == null ? void 0 : r.frozenMete) || 0);
          f.quantity > P && h.value.push(f);
        });
      }
      if (h.value.length > 0) {
        Q.error("标红部分库存不足");
        return;
      }
      await t(s), Q.success("已加入出库清单"), F("success"), N(), setTimeout(() => {
        me();
      }, 0);
    } catch (e) {
      console.log("出库办理", e);
    } finally {
      R.value = false;
    }
  }
  function ge(e) {
    e ? a.value.list = k.value.filter((t) => t.boolPartyA !== true || t.boolPartyA === true && t.project.id === e) : a.value.list = k.value, D(), q(a.value.list);
  }
  function D() {
    u.projectWarehouseType === S.PUBLIC.V ? a.value.list.forEach((e) => {
      var s;
      if (e.factoryId = (s = e.factory) == null ? void 0 : s.id, !a.value.projectId || !e.projectFrozenKV || !e.projectFrozenKV[a.value.projectId]) e.projectOperableQuantity = e.operableQuantity, e.projectOperableMete = e.operableMete, e.corProjectOperableQuantity = e.corOperableQuantity;
      else {
        const i = e.projectFrozenKV[a.value.projectId];
        e.projectOperableQuantity = e.operableQuantity + (i.quantity || 0), e.projectOperableMete = e.operableMete + (i.mete || 0);
      }
      e.corProjectOperableQuantity = e.outboundUnitType === B.MEASURE.V ? e.projectOperableQuantity : e.projectOperableMete;
    }) : a.value.list.forEach((e) => {
      var t;
      e.factoryId = (t = e.factory) == null ? void 0 : t.id, e.corProjectOperableQuantity = e.outboundUnitType === B.MEASURE.V ? e.operableQuantity : e.operableMete;
    });
  }
  function _e(e) {
    switch (e) {
      case x.STEEL_PLATE.V:
        return at;
      case x.SECTION_STEEL.V:
        return tt;
      case x.STEEL_COIL.V:
        return et;
      case x.MATERIAL.V:
        return Ze;
      case x.OTHER.V:
        return Xe;
      case x.GAS.V:
        return Ye;
      default:
        return null;
    }
  }
  return (e, t) => {
    const s = w("common-button"), i = ke, g = w("common-select"), d = w("common-radio"), V = Ce, f = Te, r = w("common-input-number"), P = Ue, M = w("common-table"), xe = Re, je = w("common-dialog"), we = Ve("parse-project");
    return O(), A(je, { title: "出库办理", modelValue: p(v), "onUpdate:modelValue": t[6] || (t[6] = (l) => Oe(v) ? v.value = l : null), width: "95%", "before-close": p(N), "show-close": true, "custom-class": "wms-batch-outbound-handling", top: "10vh" }, { titleRight: n(() => [o(s, { loading: R.value, size: "default", type: "primary", onClick: he }, { default: n(() => t[7] || (t[7] = [T(" 提 交 ")])), _: 1, __: [7] }, 8, ["loading"])]), default: n(() => [o(xe, { ref_key: "formRef", ref: j, class: "form", model: a.value, rules: ne.value, size: "default", "label-position": "right", inline: "", "label-width": "70px" }, { default: n(() => [b("div", st, [z.value ? (O(), $(K, { key: 1 }, [z.value ? (O(), $(K, { key: 0 }, [o(i, { label: "项目", prop: "projectId", "label-width": "55px" }, { default: n(() => [o(p(Fe), { modelValue: a.value.projectId, "onUpdate:modelValue": t[0] || (t[0] = (l) => a.value.projectId = l), clearable: "", class: "input-underline", style: { width: "300px" }, onChange: ge }, null, 8, ["modelValue"])]), _: 1 }), o(i, { label: "单体", prop: "monomerId", "label-width": "55px" }, { default: n(() => {
      var l, c;
      return [o(g, { modelValue: a.value.monomerId, "onUpdate:modelValue": t[1] || (t[1] = (m) => a.value.monomerId = m), options: a.value.projectId && ((c = (l = p(Z)) == null ? void 0 : l[a.value.projectId]) == null ? void 0 : c.children) || [], dataStructure: { key: "id", label: "name", value: "id" }, class: "input-underline", clearable: "", type: "other", placeholder: "可选择单体", style: { width: "200px" } }, null, 8, ["modelValue", "options"])];
    }), _: 1 }), o(i, { label: "区域", prop: "areaId", "label-width": "55px" }, { default: n(() => {
      var l, c;
      return [o(g, { modelValue: a.value.areaId, "onUpdate:modelValue": t[2] || (t[2] = (m) => a.value.areaId = m), options: a.value.monomerId && ((c = (l = p(ee)) == null ? void 0 : l[a.value.monomerId]) == null ? void 0 : c.children) || [], dataStructure: { key: "id", label: "name", value: "id" }, class: "input-underline", clearable: "", type: "other", placeholder: "可选择区域", style: { width: "200px" } }, null, 8, ["modelValue", "options"])];
    }), _: 1 })], 64)) : G("", true)], 64)) : (O(), A(i, { key: 0, label: "包含项目", "label-width": "80px" }, { default: n(() => [Ee(b("span", null, null, 512), [[we, { project: de.value }]])]), _: 1 })), o(i, { label: "出库目的地", prop: "outboundAddress", "label-width": "95px" }, { default: n(() => [o(d, { modelValue: a.value.outboundAddress, "onUpdate:modelValue": t[3] || (t[3] = (l) => a.value.outboundAddress = l), options: p(L).ENUM, type: "enum", size: "default" }, null, 8, ["modelValue", "options"])]), _: 1 }), o(i, { label: "领用人", prop: "recipientId" }, { default: n(() => [o(He, { modelValue: a.value.recipientId, "onUpdate:modelValue": t[4] || (t[4] = (l) => a.value.recipientId = l), "collapse-tags": false, clearable: "", filterable: "", "show-all-levels": "", placeholder: "领用人", class: "input-underline", style: { width: "300px" } }, null, 8, ["modelValue"])]), _: 1 })]), o(M, { ref: "tableRef", data: a.value.list, "data-format": ie.value, "max-height": p(re), "default-expand-all": false, "cell-class-name": p(se), "expand-row-keys": U.value, "row-key": "id" }, { default: n(() => [o(Ne, { data: a.value.list, "expand-row-keys": U.value, "onUpdate:expandRowKeys": t[5] || (t[5] = (l) => U.value = l), "row-key": "id", fixed: "left" }, { default: n(({ row: l }) => [o(ze, { "basic-class": l.basicClass, row: l, "show-graphics": "" }, { default: n(() => [b("p", null, [t[8] || (t[8] = T(" 项目：")), b("span", null, J(l.projectFullName), 1)]), o(V, { modelValue: l.sourceRow.remark, "onUpdate:modelValue": (c) => l.sourceRow.remark = c, autosize: ce.value, type: "textarea", placeholder: "备注", maxlength: "200", "show-word-limit": "", style: { "max-width": "400px" } }, null, 8, ["modelValue", "onUpdate:modelValue", "autosize"])]), _: 2 }, 1032, ["basic-class", "row"])]), _: 1 }, 8, ["data", "expand-row-keys"]), o(qe, { "basic-class": y.basicClass, fixed: "left" }, null, 8, ["basic-class"]), o(De, { "operable-quantity-field": C.value ? "projectOperableQuantity" : "operableQuantity", "operable-mete-field": C.value ? "projectOperableMete" : "operableMete", "basic-class": y.basicClass }, null, 8, ["operable-quantity-field", "operable-mete-field", "basic-class"]), o(We, { "basic-class": y.basicClass, "show-batch-no": false }, null, 8, ["basic-class"]), o($e), o(f, { label: "车间", width: "170px", align: "center", fixed: "right", prop: "workshopId" }, { default: n(({ row: { sourceRow: l }, $index: c }) => [o(ot, { modelValue: l.workshopId, "onUpdate:modelValue": (m) => l.workshopId = m, type: p(Ke).WORKSHOP.V, placeholder: "可选择车间", "show-extra": c !== 0, style: { width: "100%" }, clearable: "" }, null, 8, ["modelValue", "onUpdate:modelValue", "type", "show-extra"])]), _: 1 }), o(f, { label: "出库数量", width: "230px", align: "center", fixed: "right" }, { header: n(() => [t[9] || (t[9] = b("span", null, "出库数量", -1)), b("span", { class: "text-clickable", style: { "margin-left": "10px" }, onClick: fe }, "全部出库"), b("span", { class: "text-clickable", style: { "margin-left": "10px" }, onClick: ye }, "清空")]), default: n(({ row: { sourceRow: l } }) => {
      var c;
      return [b("span", nt, [o(r, { modelValue: l.batchOutboundQuantity, "onUpdate:modelValue": (m) => l.batchOutboundQuantity = m, min: 0, precision: l.outboundUnitPrecision, max: l.corProjectOperableQuantity, "controls-position": "right" }, null, 8, ["modelValue", "onUpdate:modelValue", "precision", "max"]), b("span", it, [T(J(l.outboundUnit), 1), b("span", rt, [(y.basicClass & p(I).STEEL.V || y.basicClass & p(I).MATERIAL.V || y.basicClass & p(I).OTHER.V) && h.value.findIndex((m) => m.id === l.id) > -1 && !(l.batchOutboundQuantity < ((c = h.value.find((m) => m.id === l.id)) == null ? void 0 : c.quantity)) ? (O(), A(P, { key: 0, class: "ml-2", type: "danger", style: { "margin-left": "2px" } }, { default: n(() => t[10] || (t[10] = [T("不足")])), _: 1, __: [10] })) : G("", true)])])])];
    }), _: 1 })]), _: 1 }, 8, ["data", "data-format", "max-height", "cell-class-name", "expand-row-keys"])]), _: 1 }, 8, ["model", "rules"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  mt as default
};
