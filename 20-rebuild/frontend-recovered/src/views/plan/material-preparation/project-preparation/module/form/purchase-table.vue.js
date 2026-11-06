import { ref as J } from "vue";
import { computed as Y } from "vue";
import { reactive as w } from "vue";
import { resolveComponent as T } from "vue";
import { openBlock as d } from "vue";
import { createBlock as g } from "vue";
import { withCtx as m } from "vue";
import { createVNode as u } from "vue";
import { createElementBlock as C } from "vue";
import { toDisplayString as R } from "vue";
import { unref as V } from "vue";
import { createCommentVNode as Z } from "vue";
import { cloneDeep as ee } from "lodash";
import { nextTick as x } from "vue";
import { ElInput as te } from "element-plus";
import { ElTableColumn as ae } from "element-plus";
import { ElTooltip as ie } from "element-plus";
import { kc as ne, V as oe, i as U, cO as le, jl as re, cV as L, sK as se, cS as N, sD as S, am as E, iX as M, jN as v, sL as ce, aw as ue, b as me, aI as de } from "../../../../../../shared/runtime.js";
const pe = { key: 0 }, fe = { key: 1 }, he = { key: 1 }, Te = { __name: "purchase-table", props: { show: { type: Boolean }, height: { type: Number, default: 400 }, currentTechRow: { type: Object }, queryFilter: { type: Object, default: () => ({}) } }, setup(P, { expose: q }) {
  const f = P, s = J([]), K = Y(() => {
    let t = s.value;
    return f.queryFilter.showOnlySelectTechInfo && f.currentTechRow && (t = t.filter((a) => a.boundTechId === f.currentTechRow.id)), t;
  }), B = [["material.mete", ["to-fixed-field", "material.accountingPrecision"]]], Q = { "material.mete": [{ validator: (t, a) => a.material.measureUnit ? true : !!t && t > 0, message: "核算量必须大于0" }], "material.quantity": [{ validator: (t, a) => a.material.measureUnit ? !!t && t > 0 : true, message: "有计量单位，数量必须大于0" }] }, { tableValidate: A, wrongCellMask: D } = ue({ rules: Q, errorMsg: "请修正【需要采购清单】中标红的信息" });
  function O() {
    if (me(s.value)) return l.form.purchaseList = [], true;
    const { validResult: t, dealList: a } = A(s.value);
    return s.value = a, l.form.purchaseList = a, t;
  }
  const { CRUD: z, crud: l } = ne();
  z.HOOK.beforeEditDetailLoaded = async (t, a) => {
    s.value = await W(oe(a.purchaseList || [])), H(s.value, a.technologyList), X(s.value, a.technologyList), h(s.value);
  };
  function F(t, a) {
    l.props.inventoryExitIdMap.set(t.material.id, true);
    const e = w(ee(t));
    e.boolAdd = true, e.id = de(), e.boundTechId = a.id, l.props.technologyListKV[e.boundTechId].boundPurIds.push(e.id), _(e.material), s.value.push(e), e.material.number && j(e.material.number, void 0, e);
  }
  function $(t, a) {
    l.props.inventoryExitIdMap.set(t.material.id, false), s.value.splice(a, 1);
    const e = l.props.technologyListKV[t.boundTechId];
    e.boundPurIds.remove(t.id), b(s.value, e), h(s.value);
  }
  function j(t, a, e) {
    e.material.outboundUnitType === N.MEASURE.V ? k(t, a, e) : I(t, a, e);
  }
  function k(t, a, e) {
    const { material: i } = e, o = () => {
      a !== i.quantity && (i.basicClass & L && _(i), b(s.value, l.props.technologyListKV[e.boundTechId]), h(s.value));
    };
    !t || t < i.lowerLimitQuantity ? x(() => {
      i.quantity = i.lowerLimitQuantity, o();
    }) : o();
  }
  function I(t, a, e) {
    const { material: i } = e, o = () => {
      a !== i.mete && (b(s.value, l.props.technologyListKV[e.boundTechId]), h(s.value));
    };
    !t || t < i.lowerLimitMete ? x(() => {
      i.mete = i.lowerLimitMete, o();
    }) : o();
  }
  function h(t) {
    U(t) ? l.props.purchaseTotalMete = t.reduce((a, e) => a += e.material.mete || 0, 0) : l.props.purchaseTotalMete = 0;
  }
  async function W(t) {
    return t ? (await le(t, { prefix: "material" }), await re(t, { prefix: "material", toNum: true }, { mete: ["mete", "sortingMete"], quantity: ["quantity", "sortingQuantity"] }), l.form.materialBasicClass & L && await se(t, { prefix: "material" }), t.forEach((a) => {
      const { material: e } = a;
      e.outboundUnitType === N.MEASURE.V ? (e.number = e.quantity, e.sortingNumber = e.sortingQuantity, e.lowerLimitQuantity = e.sortingQuantity) : (e.number = e.mete, e.sortingNumber = e.sortingMete, e.lowerLimitMete = e.sortingMete), e.operableNumber = 999999999, e.lowerLimitNumber = e.sortingNumber, a = w(a), e.basicClass & L && _(e);
    }), t) : [];
  }
  function H(t, a) {
    if (l.form.technologyListType === S.STRUCTURE.V) {
      const e = l.props.steelClassifyConfICKV;
      t.forEach((i) => {
        const { material: o } = i;
        for (const r of a) {
          const p = e[r.steelClassifyConfId] || [];
          if (o.basicClass === E.STEEL_PLATE.V && p.includes(o.classifyId) && o.specNameKV.材质 === r.material && `${o.theoryThickness}` === r.specification) {
            i.boundTechId = r.id, r.boundPurIds.push(i.id);
            break;
          }
          if (o.basicClass === E.SECTION_STEEL.V && p.includes(o.classifyId) && o.specNameKV.材质 === r.material && o.specNameKV[o.nationalStandard] === r.specification) {
            i.boundTechId = r.id, r.boundPurIds.push(i.id);
            break;
          }
        }
      });
    }
  }
  function X(t, a) {
    a.forEach((e) => {
      l.props.techPrepMeteKV[e.id] = l.props.techPrepMeteKV[e.id] || {}, b(t, e);
    });
  }
  function b(t, a) {
    const e = l.props.techPrepMeteKV[a.id], i = [];
    if (a.boundPurIds.forEach((o) => {
      for (const r of t) if (r.id === o) {
        i.push(r.material);
        break;
      }
    }), l.form.technologyListType === S.STRUCTURE.V) {
      const o = i.reduce((r, p) => r += p.mete || 0, 0);
      e.purchase = M(o, v.weight.precision), e.preparation = M((e.inventory || 0) + (e.purchase || 0), v.weight.precision), e.diff = M(e.preparation - a.listMete, v.weight.precision), e.isEnough = e.diff >= 0;
    }
  }
  function _(t) {
    U(t.theoryWeight) && t.quantity ? t.mete = t.theoryWeight * t.quantity : t.mete = void 0;
  }
  return q({ add: F, validate: O }), (t, a) => {
    const e = te, i = ae, o = T("common-input-number"), r = ie, p = T("common-button"), G = T("common-table");
    return f.show ? (d(), g(G, { key: 0, ref: "tableRef", data: K.value, "data-format": B, height: f.height, "default-expand-all": false, "cell-class-name": V(D), "highlight-current-row": "", "row-key": "id" }, { default: m(() => [u(ce, { "spec-merge": "", fixed: "left" }), u(i, { prop: "material.brand", label: "品牌", align: "center", "min-width": "100px", fixed: "left" }, { default: m(({ row: { sourceRow: n } }) => [n.lowerLimitNumber ? (d(), C("span", pe, R(n.material.brand), 1)) : (d(), g(e, { key: 1, modelValue: n.material.brand, "onUpdate:modelValue": (c) => n.material.brand = c, modelModifiers: { trim: true }, maxlength: "60", size: "default", placeholder: "品牌" }, null, 8, ["modelValue", "onUpdate:modelValue"]))]), _: 1 }), u(i, { prop: "material.measureUnit", label: "计量单位", align: "center", "min-width": "70px" }), u(i, { prop: "material.quantity", label: "数量", align: "center", "min-width": "120px" }, { default: m(({ row: n }) => [n.sourceRow.material.measureUnit ? (d(), g(r, { key: 0, effect: "dark", content: `当前记录已分拣：${n.sourceRow.material.lowerLimitQuantity}`, "show-after": 1e3, placement: "top-start" }, { default: m(() => [u(o, { modelValue: n.sourceRow.material.quantity, "onUpdate:modelValue": (c) => n.sourceRow.material.quantity = c, min: n.sourceRow.material.lowerLimitQuantity, max: 999999999, controls: false, step: 1, precision: +n.sourceRow.material.measurePrecision, size: "default", placeholder: "数量", onChange: (c, y) => k(c, y, n.sourceRow) }, null, 8, ["modelValue", "onUpdate:modelValue", "min", "precision", "onChange"])]), _: 2 }, 1032, ["content"])) : (d(), C("span", fe, "-"))]), _: 1 }), u(i, { prop: "material.accountingUnit", label: "核算单位", align: "center", "min-width": "70px" }), u(i, { prop: "material.mete", label: "核算量", align: "center", "min-width": "120px" }, { default: m(({ row: n }) => [V(l).form.materialBasicClass === V(E).MATERIAL.V ? (d(), g(r, { key: 0, effect: "dark", content: `当前记录已分拣：${n.sourceRow.material.lowerLimitMete || 0}`, "show-after": 1e3, placement: "top-start" }, { default: m(() => [u(o, { modelValue: n.sourceRow.material.mete, "onUpdate:modelValue": (c) => n.sourceRow.material.mete = c, min: n.sourceRow.material.lowerLimitMete, max: 999999999, controls: false, step: 1, precision: +n.sourceRow.material.accountingPrecision, size: "default", placeholder: "核算量", onChange: (c, y) => I(c, y, n.sourceRow) }, null, 8, ["modelValue", "onUpdate:modelValue", "min", "precision", "onChange"])]), _: 2 }, 1032, ["content"])) : (d(), C("span", he, R(n.material.mete || 0), 1))]), _: 1 }), u(i, { key: "remark", prop: "remark", align: "center", label: "备注", "min-width": "150px" }, { default: m(({ row: { sourceRow: n } }) => [u(e, { modelValue: n.remark, "onUpdate:modelValue": (c) => n.remark = c, placeholder: "备注", maxlength: "200", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), u(i, { label: "操作", width: "70", align: "center", fixed: "right" }, { default: m(({ row: { sourceRow: n }, $index: c }) => [u(p, { class: "icon-button", icon: "el-icon-delete", type: "danger", size: "default", disabled: n.material.lowerLimitNumber > 0, onClick: (y) => $(n, c) }, null, 8, ["disabled", "onClick"])]), _: 1 })]), _: 1 }, 8, ["data", "height", "cell-class-name"])) : Z("", true);
  };
} };
export {
  Te as default
};
