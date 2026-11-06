import { inject as $ } from "vue";
import { ref as x } from "vue";
import { computed as b } from "vue";
import { watch as ee } from "vue";
import * as q from "lodash";
import { resolveComponent as I } from "vue";
import { openBlock as n } from "vue";
import { createElementBlock as l } from "vue";
import { createVNode as _ } from "vue";
import { withCtx as u } from "vue";
import { withDirectives as oe } from "vue";
import { createTextVNode as V } from "vue";
import { vShow as te } from "vue";
import { Fragment as d } from "vue";
import { renderList as S } from "vue";
import { createBlock as D } from "vue";
import { resolveDynamicComponent as N } from "vue";
import { mergeProps as C } from "vue";
import { toDisplayString as s } from "vue";
import { createCommentVNode as w } from "vue";
import { unref as j } from "vue";
import { ElDescriptionsItem as ne } from "element-plus";
import { ElDescriptions as le } from "element-plus";
import { gt as ae, D as se } from "../../../../shared/runtime.js";
const ce = { class: "detail-container" }, re = { key: 1 }, ue = { key: 2 }, ie = { key: 1 }, pe = { key: 1 }, de = { key: 2 }, ye = { key: 0 }, me = { key: 1 }, ke = { key: 2 }, he = { key: 1 }, be = { __name: "detail", props: { modelValue: { type: Boolean, default: true }, currentRow: { type: Object, default: () => ({}) } }, emits: ["close"], setup(z, { emit: B }) {
  const i = z, M = B, { crud: m, CRUD: L } = ae(), K = $("enclosureDictList"), W = x({}), o = x({ one: {}, two: {} }), G = [{ label: "项目", key: "projectName", componentType: "span" }, { label: "清单数量（张）", key: "quantity", componentType: "el-input-number", componentProps: { min: b(() => {
    var t;
    return (t = o.value.one) == null ? void 0 : t.shippedQuantity;
  }), controlsPosition: "right" } }, { label: "已生产（张）", key: "producedQuantity", componentType: "span", componentProps: { min: b(() => {
    var t;
    return (t = o.value.one) == null ? void 0 : t.shippedQuantity;
  }), controlsPosition: "right" } }, { label: "未生产（张）", key: "notProduced", componentType: "span", componentProps: { min: 0, controlsPosition: "right" } }, { label: "已发运（张）", key: "shippedQuantity", componentType: "span" }], Y = [{ label: "类型", key: "dictionaryName", idKey: "dictionaryId", componentType: "el-input" }, { label: "名称", key: "name", componentType: "el-input" }, { label: "编号", key: "serialNumber", componentType: () => {
    var t;
    return (t = o.value.one) != null && t.producedQuantity ? "span" : "el-input";
  } }, { label: "规格", key: "plate", componentType: "el-input" }, { label: "展开宽度（mm）", key: "unfoldedWidth", componentType: "el-input-number", componentProps: { min: 0, controlsPosition: "right" } }, { label: "有效宽度（mm）", key: "width", componentType: "el-input-number", componentProps: { min: 0, controlsPosition: "right" } }, { label: "折弯次数", key: "bendTimes", componentType: "el-input" }, { label: "厚度（mm）", key: "thickness", componentType: "el-input-number", componentProps: { min: 0, controlsPosition: "right" } }, { label: "单长（mm）", key: "length", componentType: "el-input-number", componentProps: { min: 0, controlsPosition: "right" } }, { label: "核算量（米）", key: "accountingVolume", componentType: "el-input" }, { label: "面积（m²）", key: "totalArea", componentType: "el-input" }, { label: "重量（kg）", key: "totalWeight", componentType: "el-input" }, { label: "备注", key: "remark", componentType: "el-input" }], H = ["producedQuantity", "notProduced", "shippedQuantity"];
  ee(() => i.currentRow, async () => {
    if (!i.currentRow || Object.keys(i.currentRow).length === 0) return;
    const t = { ...i.currentRow };
    i.currentRow.dictionaryId, o.value = { one: { ...i.currentRow }, two: t }, W.value = q.cloneDeep(o.value);
  }, { immediate: true, deep: true });
  const k = b(() => {
    const { schedulingQuantity: t, quantity: c, producedQuantity: r } = i.currentRow;
    return t > 0 && t < c ? "processed" : r === c ? "finished" : "haveOut";
  }), A = b(() => !!Number(i.currentRow.shippedQuantity)), E = b(() => {
    const t = o.value.two.dictionaryName, { quantity: c } = o.value.one, { unfoldedWidth: r, width: a, thickness: h, length: F } = o.value.two, e = parseFloat(r) || 0, p = parseFloat(a) || 0, g = parseFloat(h) || 0, y = parseFloat(F) || 0, P = parseFloat(c) || 1;
    let v = 0;
    switch (t) {
      case "折边件":
        v = e * y / 1e6;
        break;
      default:
        v = p * y / 1e6;
    }
    const R = v * P;
    let f = 0;
    switch (t) {
      case "压型彩板":
      case "折边件":
        f = e * g * y * 7.85 / 1e6;
        break;
      case "压型楼层板":
      case "桁架楼层板":
        f = p * g * y * 7.85 / 1e6;
        break;
    }
    const U = t === "夹芯板" ? "" : (f * P).toFixed(se.COM_WT__KG);
    return { totalArea: R.toFixed(4), totalWeight: U || 0 };
  });
  async function J() {
    var t;
    try {
      const c = {};
      Object.keys(o.value.one).forEach((a) => {
        q.isEqual(o.value.one[a], W.value.one[a]) || (c[a] = o.value.one[a]);
      }), delete o.value.two.quantity, delete o.value.two.notProduced, delete o.value.two.producedQuantity;
      const r = { ...i.currentRow, ...o.value.one, ...c, ...o.value.two, ...E.value };
      if (r.dictionaryName) {
        const a = (t = K.value) == null ? void 0 : t.find((h) => h.id === r.dictionaryName);
        a && (r.dictionaryName = a.label);
      }
      H.forEach((a) => delete r[a]), await m.crudApi.edit(r), m.notify("操作成功", L.NOTIFICATION_TYPE.SUCCESS), m.cancelDetail(), m.toQuery();
    } catch (c) {
      console.error(c);
    }
  }
  const X = b(() => !q.isEqual(o.value, W.value));
  function Q(t) {
    return typeof t == "string" ? t : t();
  }
  function Z() {
    M("close");
  }
  return (t, c) => {
    const r = I("common-button"), a = ne, h = le, F = I("common-drawer");
    return n(), l("div", ce, [_(F, { "before-close": j(m).cancelDetail, "close-on-click-modal": false, visible: j(m).detailVisible, size: "30%", title: "清单明细", onClosed: Z }, { titleRight: u(() => [oe(_(r, { size: "default", type: "primary", onClick: J }, { default: u(() => c[0] || (c[0] = [V("修改 ")])), _: 1, __: [0] }, 512), [[te, X.value]])]), content: u(() => [_(h, { column: 1, border: "", "label-width": "140", size: "default", style: { "margin-bottom": "10px" } }, { default: u(() => [(n(), l(d, null, S(G, (e) => _(a, { key: e.key, label: e.label }, { default: u(() => {
      var p, g, y, P, v, R, f, U, O;
      return [A.value ? (n(), l(d, { key: 1 }, [["quantity"].includes(e.key) ? (n(), D(N(e.componentType), C({ key: 0, modelValue: o.value.one[e.key], "onUpdate:modelValue": (T) => o.value.one[e.key] = T, placeholder: e.label, style: { width: "100%" } }, { ref_for: true }, { ...e.componentProps, min: ((U = (f = e.componentProps) == null ? void 0 : f.min) == null ? void 0 : U.value) ?? ((O = e.componentProps) == null ? void 0 : O.min) }), null, 16, ["modelValue", "onUpdate:modelValue", "placeholder"])) : (n(), l("span", ie, s(o.value.one[e.key]), 1))], 64)) : (n(), l(d, { key: 0 }, [k.value === "haveOut" ? (n(), D(N(Q(e.componentType)), C({ key: 0, modelValue: o.value.one[e.key], "onUpdate:modelValue": (T) => o.value.one[e.key] = T, placeholder: e.label, style: { width: "100%" } }, { ref_for: true }, { ...e.componentProps, min: ((g = (p = e.componentProps) == null ? void 0 : p.min) == null ? void 0 : g.value) ?? ((y = e.componentProps) == null ? void 0 : y.min) }), { default: u(() => [V(s(o.value.one[e.key]), 1)]), _: 2 }, 1040, ["modelValue", "onUpdate:modelValue", "placeholder"])) : w("", true), k.value === "processed" ? (n(), l(d, { key: 1 }, [["producedQuantity", "notProduced", "quantity"].includes(e.key) ? (n(), D(N(Q(e.componentType)), C({ key: 0, modelValue: o.value.one[e.key], "onUpdate:modelValue": (T) => o.value.one[e.key] = T, placeholder: e.label, style: { width: "100%" } }, { ref_for: true }, { ...e.componentProps, min: ((v = (P = e.componentProps) == null ? void 0 : P.min) == null ? void 0 : v.value) ?? ((R = e.componentProps) == null ? void 0 : R.min) }), { default: u(() => [V(s(o.value.one[e.key]), 1)]), _: 2 }, 1040, ["modelValue", "onUpdate:modelValue", "placeholder"])) : (n(), l("span", re, s(o.value.one[e.key]), 1))], 64)) : w("", true), k.value === "finished" ? (n(), l("span", ue, s(o.value.one[e.key]), 1)) : w("", true)], 64))];
    }), _: 2 }, 1032, ["label"])), 64))]), _: 1 }), _(h, { column: 1, border: "", "label-width": "140", size: "default" }, { default: u(() => [(n(), l(d, null, S(Y, (e) => _(a, { key: e.key, label: e.label }, { default: u(() => [A.value ? (n(), l("span", he, s(o.value.two[e.key]), 1)) : (n(), l(d, { key: 0 }, [k.value === "haveOut" ? (n(), l(d, { key: 0 }, [["dictionaryName", "totalArea", "totalWeight"].includes(e.key) ? ["totalArea", "totalWeight"].includes(e.key) ? (n(), l("span", pe, s(E.value[e.key]), 1)) : (n(), l("span", de, s(o.value.two[e.key]), 1)) : (n(), D(N(Q(e.componentType)), C({ key: 0, modelValue: o.value.two[e.key], "onUpdate:modelValue": (p) => o.value.two[e.key] = p, placeholder: e.label, style: { width: "100%" } }, { ref_for: true }, e.componentProps), { default: u(() => [V(s(o.value.two[e.key]), 1)]), _: 2 }, 1040, ["modelValue", "onUpdate:modelValue", "placeholder"]))], 64)) : w("", true), k.value === "processed" ? (n(), l(d, { key: 1 }, [["unfoldedWidth", "width", "thickness", "length", "name", "totalArea", "totalWeight"].includes(e.key) ? ["totalArea", "totalWeight"].includes(e.key) ? (n(), l("span", me, s(E.value[e.key]), 1)) : (n(), D(N(Q(e.componentType)), C({ key: 2, modelValue: o.value.two[e.key], "onUpdate:modelValue": (p) => o.value.two[e.key] = p, placeholder: e.label, style: { width: "100%" } }, { ref_for: true }, e.componentProps), { default: u(() => [V(s(o.value.two[e.key]), 1)]), _: 2 }, 1040, ["modelValue", "onUpdate:modelValue", "placeholder"])) : (n(), l("span", ye, s(o.value.two[e.key]), 1))], 64)) : w("", true), k.value === "finished" ? (n(), l("span", ke, s(o.value.two[e.key]), 1)) : w("", true)], 64))]), _: 2 }, 1032, ["label"])), 64))]), _: 1 })]), _: 1 }, 8, ["before-close", "visible"])]);
  };
} };
export {
  be as default
};
