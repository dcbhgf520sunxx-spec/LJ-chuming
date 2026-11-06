import { ref as Y } from "vue";
import { computed as G } from "vue";
import { reactive as L } from "vue";
import { resolveComponent as v } from "vue";
import { openBlock as p } from "vue";
import { createBlock as C } from "vue";
import { withCtx as f } from "vue";
import { createVNode as u } from "vue";
import { unref as _ } from "vue";
import { createElementBlock as T } from "vue";
import { Fragment as H } from "vue";
import { toDisplayString as R } from "vue";
import { createCommentVNode as J } from "vue";
import { cloneDeep as Z } from "lodash";
import { nextTick as k } from "vue";
import { ElTableColumn as ee } from "element-plus";
import { ElTooltip as te } from "element-plus";
import { ElInput as ae } from "element-plus";
import { kc as ne, V as ie, cO as oe, jl as se, cV as E, sK as re, cS as V, i as I, sD as N, am as x, jN as le, iX as h, sL as ue, sM as ce, sN as de, aw as me, b as pe, aI as fe } from "../../../../../../shared/runtime.js";
const be = { key: 1 }, he = { key: 1 }, ye = { key: 1 }, Ie = { __name: "inventory-table", props: { show: { type: Boolean }, height: { type: Number, default: 400 }, currentTechRow: { type: Object }, queryFilter: { type: Object, default: () => ({}) } }, setup(Q, { expose: S }) {
  const b = Q, l = Y([]), w = G(() => {
    let t = l.value;
    return b.queryFilter.showOnlySelectTechInfo && b.currentTechRow && (t = t.filter((n) => n.boundTechId === b.currentTechRow.id)), t;
  }), j = [["material.usedMete", ["to-fixed-field", "material.accountingPrecision"]], ["material.usedQuantity", ["to-fixed-field", "material.measurePrecision"]]], O = { "material.usedMete": [{ validator: (t, n) => n.material.measureUnit ? true : !!t && t > 0, message: "核算量必须大于0" }], "material.usedQuantity": [{ validator: (t, n) => n.material.measureUnit ? !!t && t > 0 : true, message: "有计量单位，数量必须大于0" }] }, { tableValidate: A, wrongCellMask: K } = me({ rules: O, errorMsg: "请修正【需要采购清单】中标红的信息" });
  function P() {
    if (pe(l.value)) return s.form.inventoryList = [], true;
    const { validResult: t, dealList: n } = A(l.value);
    return l.value = n, s.form.inventoryList = n, t;
  }
  const { CRUD: B, crud: s } = ne();
  B.HOOK.beforeEditDetailLoaded = async (t, n) => {
    l.value = await z(ie(n.inventoryList || []));
    const e = /* @__PURE__ */ new Map();
    l.value.forEach((a) => {
      e.set(a.material.id, true);
    }), t.props.inventoryExitIdMap = e, W(l.value, n.technologyList), X(l.value, n.technologyList), y(l.value);
  };
  async function z(t) {
    return t ? (await oe(t, { prefix: "material" }), await se(t, { prefix: "material", toNum: true }, { mete: ["mete", "usedMete", "frozenMete", "projectUsedMete", "projectOutboundUsedMete"], quantity: ["quantity", "usedQuantity", "frozenQuantity", "projectUsedQuantity", "projectOutboundUsedQuantity"] }), s.form.materialBasicClass & E && await re(t, { prefix: "material" }), t.forEach((n) => {
      const { material: e } = n;
      e.outboundUnitType === V.MEASURE.V ? (e.number = e.quantity, e.usedNumber = e.usedQuantity, e.frozenNumber = e.frozenQuantity, e.projectOperableNumber = e.projectUsedQuantity - e.projectOutboundUsedQuantity) : (e.number = e.mete, e.usedNumber = e.usedMete, e.frozenNumber = e.frozenMete, e.projectOperableNumber = e.projectUsedMete - e.projectOutboundUsedMete), e.operableNumber = e.number - (e.frozenNumber || 0) + (e.projectOperableNumber >= e.usedNumber ? e.usedNumber : e.projectOperableNumber), e.lowerLimitNumber = e.usedNumber - e.projectOperableNumber >= 0 ? e.usedNumber - e.projectOperableNumber : 0, n = L(n), e.basicClass & E && U(e);
    }), t) : [];
  }
  function q(t, n) {
    s.props.inventoryExitIdMap.set(t.material.id, true);
    const e = L(Z(t));
    e.boolAdd = true, e.id = fe(), e.boundTechId = n.id;
    const a = s.props.technologyListKV[e.boundTechId];
    a && a.boundInvIds.push(e.id), l.value.push(e);
  }
  function D(t, n) {
    s.props.inventoryExitIdMap.set(t.material.id, false), l.value.splice(n, 1);
    const e = t.boundTechId, a = s.props.technologyListKV[e];
    a && a.boundInvIds.remove(t.id), M(l.value, a), y(l.value);
  }
  function $(t, n, e) {
    const { material: a } = e, i = () => {
      n !== a.usedQuantity && (a.basicClass & E ? U(a) : I(a.usedQuantity) ? a.usedMete = h(a.usedQuantity / a.quantity * a.mete, e.accountingPrecision) : a.usedMete = void 0, M(l.value, s.props.technologyListKV[e.boundTechId]), y(l.value));
    };
    !t || t < a.lowerLimitNumber ? k(() => {
      a.usedQuantity = a.lowerLimitNumber, i();
    }) : i();
  }
  function F(t, n, e) {
    const { material: a } = e, i = () => {
      n !== a.usedMete && (a.measureUnit && I(a.usedMete) ? a.usedQuantity = h(a.usedMete / a.mete * a.quantity, e.measurePrecision) : a.usedQuantity = void 0, M(l.value, s.props.technologyListKV[e.boundTechId]), y(l.value));
    };
    !t || t < a.lowerLimitNumber ? k(() => {
      a.usedMete = a.lowerLimitNumber, i();
    }) : i();
  }
  function y(t) {
    I(t) ? s.props.inventoryTotalMete = t.reduce((n, e) => n += e.material.usedMete || 0, 0) : s.props.inventoryTotalMete = 0;
  }
  function U(t) {
    I(t.theoryWeight) && t.usedQuantity ? t.usedMete = t.theoryWeight * t.usedQuantity : t.usedMete = void 0;
  }
  function W(t, n) {
    if (s.form.technologyListType === N.STRUCTURE.V) {
      const e = s.props.steelClassifyConfICKV;
      t.forEach((a) => {
        const { material: i } = a;
        for (const r of n) {
          const d = e[r.steelClassifyConfId] || [];
          if (i.basicClass === x.STEEL_PLATE.V && d.includes(i.classifyId) && i.specNameKV.材质 === r.material && `${i.theoryThickness}` === r.specification) {
            a.boundTechId = r.id, r.boundInvIds.push(a.id);
            break;
          }
          if (i.basicClass === x.SECTION_STEEL.V && d.includes(i.classifyId) && i.specNameKV.材质 === r.material && i.specNameKV[i.nationalStandard] === r.specification) {
            a.boundTechId = r.id, r.boundInvIds.push(a.id);
            break;
          }
        }
      });
    }
    s.form.technologyListType === N.AUXILIARY_MATERIAL.V && t.forEach((e) => {
      const { material: a } = e;
      for (const i of n) if (a.serialNumber === i.serialNumber && a.brand === i.brand && a.color === i.color) {
        e.boundTechId = i.id, i.boundInvIds.push(e.id);
        break;
      }
    });
  }
  function X(t, n) {
    n.forEach((e) => {
      s.props.techPrepMeteKV[e.id] = s.props.techPrepMeteKV[e.id] || {}, M(t, e);
    });
  }
  function M(t, n) {
    const e = s.props.techPrepMeteKV[n.id], a = [];
    n.boundInvIds.forEach((d) => {
      for (const m of t) if (m.id === d) {
        a.push(m.material);
        break;
      }
    });
    let i = 0, r = 2;
    s.form.technologyListType === N.STRUCTURE.V && (i = a.reduce((d, m) => d += m.usedMete || 0, 0), r = le.weight.precision), s.form.technologyListType === N.AUXILIARY_MATERIAL.V && (i = a.reduce((d, m) => d += m.usedMete || 0, 0), r = n.accountingPrecision), e.inventory = h(i, r), e.preparation = h((e.inventory || 0) + (e.purchase || 0), r), e.diff = h(e.preparation - n.listMete, r), e.isEnough = e.diff >= 0;
  }
  return S({ add: q, validate: P }), (t, n) => {
    const e = ee, a = v("common-input-number"), i = te, r = ae, d = v("common-button"), m = v("common-table");
    return b.show ? (p(), C(m, { key: 0, ref: "tableRef", data: w.value, "data-format": j, height: b.height, "default-expand-all": false, "cell-class-name": _(K), "highlight-current-row": "", "row-key": "id" }, { default: f(() => [u(ue, { "spec-merge": "", fixed: "left" }), u(ce, { "basic-class": _(s).form.materialBasicClass, fixed: "left" }, null, 8, ["basic-class"]), u(de, { fixed: "left" }), u(e, { prop: "material.measureUnit", label: "计量单位", align: "center", "min-width": "70px" }), u(e, { prop: "material.usedQuantity", label: "数量", align: "center", "min-width": "120px" }, { default: f(({ row: o }) => [o.material.measureUnit ? (p(), T(H, { key: 0 }, [o.sourceRow.material.outboundUnitType === _(V).MEASURE.V ? (p(), C(i, { key: 0, effect: "dark", content: `当前物料最大可利用数：${o.sourceRow.material.operableNumber}`, "show-after": 1e3, placement: "top-start" }, { default: f(() => [u(a, { modelValue: o.sourceRow.material.usedQuantity, "onUpdate:modelValue": (c) => o.sourceRow.material.usedQuantity = c, min: o.sourceRow.material.lowerLimitNumber, max: o.sourceRow.material.operableNumber, controls: false, step: 1, precision: +o.sourceRow.material.measurePrecision, size: "default", placeholder: "数量", onChange: (c, g) => $(c, g, o.sourceRow) }, null, 8, ["modelValue", "onUpdate:modelValue", "min", "max", "precision", "onChange"])]), _: 2 }, 1032, ["content"])) : (p(), T("span", be, R(o.material.usedQuantity || 0), 1))], 64)) : (p(), T("span", he, "-"))]), _: 1 }), u(e, { prop: "material.accountingUnit", label: "核算单位", align: "center", "min-width": "70px" }), u(e, { prop: "material.usedMete", label: "核算量", align: "center", "min-width": "120px" }, { default: f(({ row: o }) => [o.sourceRow.material.outboundUnitType === _(V).ACCOUNTING.V ? (p(), C(i, { key: 0, effect: "dark", content: `当前物料最大可利用数：${o.sourceRow.material.operableNumber}`, "show-after": 1e3, placement: "top-start" }, { default: f(() => [u(a, { modelValue: o.sourceRow.material.usedMete, "onUpdate:modelValue": (c) => o.sourceRow.material.usedMete = c, min: o.sourceRow.material.lowerLimitNumber, max: o.sourceRow.material.operableNumber, controls: false, step: 1, precision: +o.sourceRow.material.accountingPrecision, size: "default", placeholder: "核算量", onChange: (c, g) => F(c, g, o.sourceRow) }, null, 8, ["modelValue", "onUpdate:modelValue", "min", "max", "precision", "onChange"])]), _: 2 }, 1032, ["content"])) : (p(), T("span", ye, R(o.material.usedMete || 0), 1))]), _: 1 }), u(e, { key: "remark", prop: "remark", align: "center", label: "备注", "min-width": "150px" }, { default: f(({ row: { sourceRow: o } }) => [u(r, { modelValue: o.remark, "onUpdate:modelValue": (c) => o.remark = c, placeholder: "备注", maxlength: "200", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), u(e, { label: "操作", width: "70", align: "center", fixed: "right" }, { default: f(({ row: { sourceRow: o }, $index: c }) => [u(d, { class: "icon-button", icon: "el-icon-delete", type: "danger", size: "default", disabled: o.material.lowerLimitNumber > 0, onClick: (g) => D(o, c) }, null, 8, ["disabled", "onClick"])]), _: 1 })]), _: 1 }, 8, ["data", "height", "cell-class-name"])) : J("", true);
  };
} };
export {
  Ie as default
};
