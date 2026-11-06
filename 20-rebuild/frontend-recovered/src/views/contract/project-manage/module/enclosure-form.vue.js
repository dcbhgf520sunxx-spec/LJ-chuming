import { ref as y } from "vue";
import { watch as D } from "vue";
import { nextTick as j } from "vue";
import { computed as te } from "vue";
import { resolveComponent as ie } from "vue";
import { withDirectives as q } from "vue";
import { openBlock as d } from "vue";
import { createElementBlock as f } from "vue";
import { createVNode as _ } from "vue";
import { withCtx as p } from "vue";
import { Fragment as V } from "vue";
import { renderList as T } from "vue";
import { unref as E } from "vue";
import { createBlock as m } from "vue";
import { createTextVNode as B } from "vue";
import { toDisplayString as I } from "vue";
import { ElRadioGroup as ne } from "element-plus";
import { createElementVNode as R } from "vue";
import { vShow as re } from "vue";
import { resolveDynamicComponent as ue } from "vue";
import { ElMessage as de } from "element-plus";
import { ElRadioButton as oe } from "element-plus";
import { ElOption as se } from "element-plus";
import { ElSelect as ce } from "element-plus";
import { ElFormItem as fe } from "element-plus";
import { ElInput as pe } from "element-plus";
import { ElInputNumber as me } from "element-plus";
import { ElForm as ve } from "element-plus";
import { vLoading as _e } from "element-plus";
import { _ as he, dn as l, i as N, jx as ge, R as ye, S as Ve } from "../../../../shared/runtime.js";
import Ee from "./enclosure-table/sandwich-table.vue.js";
import Te from "./enclosure-table/pressed-color-table.vue.js";
import Re from "./enclosure-table/pressed-support-table.vue.js";
import Se from "./enclosure-table/structure-table.vue.js";
import be from "./enclosure-table/truss-support-table.vue.js";
const Ue = { class: "app-container" }, Pe = { class: "form-title" }, we = { class: "form-row" }, Le = { key: 0 }, Oe = { key: 1, style: { "margin-top": "10px" } }, Ae = { style: { float: "right", "margin-bottom": "10px" } }, Ce = { __name: "enclosure-form", props: { initForm: { type: Object, default: () => {
} }, showItem: { type: Array, default: () => [] }, showCategory: { type: Array, default: () => [] }, defaultType: { type: [String, Number], default: void 0 }, enclosureVisible: { type: Boolean, default: false } }, setup(F, { expose: G }) {
  const h = F, a = y(), v = y({ [l.STRUCTURE.V]: [], [l.PROFILED_PLATE.V]: [], [l.TRUSS_FLOOR_PLATE.V]: [], [l.PRESSURE_BEARING_PLATE.V]: [], [l.SANDWICH_BOARD.V]: [] }), t = y({ dict: {} }), P = y({}), w = y([]), S = y(false), g = y(), L = y(false), k = y([]);
  D(() => a.value, (o, e) => {
    S.value = false, L.value && g.value.validate((u) => {
      if (u) {
        const s = Object.assign({}, t.value);
        v.value[e].push(s);
      }
    }), a.value && O(), a.value && a.value !== l.STRUCTURE.V && $();
  }, { immediate: true }), D(() => h.defaultType, (o) => {
    o ? a.value = h.defaultType : a.value = h.showItem.length > 0 ? h.showItem[0] : void 0;
  }, { deep: true, immediate: true }), D(() => h.enclosureVisible, (o) => {
    o && (N(h.initForm) ? v.value = JSON.parse(JSON.stringify(h.initForm)) : v.value = { [l.STRUCTURE.V]: [], [l.PROFILED_PLATE.V]: [], [l.TRUSS_FLOOR_PLATE.V]: [], [l.PRESSURE_BEARING_PLATE.V]: [], [l.SANDWICH_BOARD.V]: [] }, a.value && O(), a.value && a.value !== l.STRUCTURE.V && $(), g.value && j(() => {
      g.value.clearValidate();
    }));
  }, { deep: true, immediate: true });
  const H = te(() => {
    switch (a.value) {
      case l.STRUCTURE.V:
        return Se;
      case l.PROFILED_PLATE.V:
        return Te;
      case l.TRUSS_FLOOR_PLATE.V:
        return be;
      case l.PRESSURE_BEARING_PLATE.V:
        return Re;
      case l.SANDWICH_BOARD.V:
        return Ee;
      default:
        return null;
    }
  }), n = (o, e) => [{ required: true, message: o, trigger: ["change", "blur"] }, { max: e, message: `长度在 ${e} 个字符以内`, trigger: ["change", "blur"] }], b = (o, e, u) => {
    var s = /^(?!(0[0-9]{0,}$))[0-9]{1,}[.]{0,}[0-9]{0,3}$/;
    e ? s.test(e) ? u() : u(new Error("请输入数字且最多保留3位小数")) : u(new Error("请选择或填写厚度"));
  }, M = (o, e, u) => {
    var s = /^(?!(0[0-9]{0,}$))[0-9]{1,}[.]{0,}[0-9]{0,2}$/;
    e ? s.test(e) ? u() : u(new Error("请输入数字且最多保留2位小数")) : u(new Error("请选择或填写容重"));
  }, x = (o, e, u) => {
    var s = /^[+]{0,1}(\d+)$/;
    e ? s.test(e) ? u() : u(new Error("请输入整数")) : u(new Error("请选择或填写有效宽度"));
  }, J = { [l.STRUCTURE.V]: [{ type: "产品种类", fields: [{ field: "type", name: "产品种类", placeholder: "请选择产品种类", rules: [{ required: true, message: "请选择产品种类", trigger: ["change", "blur"] }] }] }], [l.PROFILED_PLATE.V]: [{ type: "产品信息", fields: [{ field: "brand", name: "品牌", dict: "brand", placeholder: "请选择或填写品牌", rules: n("请选择或填写品牌", 10) }, { field: "thickness", name: "厚度", dict: "thickness", placeholder: "请选择或填写厚度", rules: [{ validator: b, trigger: ["change", "blur"] }], unit: "mm", decimalPlace: 3 }, { field: "plateType", name: "板型", dict: "plate_type", placeholder: "请选择或填写板型", rules: n("请选择或填写板型", 20) }, { field: "plating", name: "镀层", dict: "cladding", placeholder: "请选择或填写镀层", rules: n("请选择或填写镀层", 20) }, { field: "colour", name: "颜色", dict: "color", placeholder: "请选择或填写颜色", rules: n("请选择或填写颜色", 10) }, { field: "coating", name: "涂层", dict: "coating", placeholder: "请选择或填写涂层", rules: n("请选择或填写涂层", 10) }, { field: "yieldStrength", name: "屈服强度", dict: "yield_strength", placeholder: "请选择或填写屈服强度", rules: n("请选择或填写屈服强度", 10) }] }], [l.TRUSS_FLOOR_PLATE.V]: [{ type: "编号", fields: [{ field: "serialNumber", name: "编号", placeholder: "请选择编号", rules: n("请选择编号", 20) }] }], [l.PRESSURE_BEARING_PLATE.V]: [{ type: "产品信息", fields: [{ field: "mode", name: "类型", dict: "mode", placeholder: "请选择或填写类型", rules: n("请选择或填写类型", 10) }, { field: "plateType", name: "板型", dict: "plate_type", placeholder: "请选择或填写板型", rules: n("请选择或填写板型", 20) }, { field: "thickness", name: "厚度", dict: "thickness", placeholder: "请选择或填写厚度", rules: [{ validator: b, trigger: ["change", "blur"] }], unit: "mm", decimalPlace: 3 }, { field: "brand", name: "品牌", dict: "brand", placeholder: "请选择或填写品牌", rules: n("请选择或填写品牌", 10) }, { field: "plating", name: "镀层", dict: "plating", placeholder: "请选择或填写镀层", rules: n("请选择或填写镀层", 20) }, { field: "yieldStrength", name: "屈服强度", dict: "yield_strength", placeholder: "请选择或填写屈服强度", rules: n("请选择或填写屈服强度", 10) }] }], [l.SANDWICH_BOARD.V]: [{ type: "产品信息", fields: [{ field: "thickness", name: "厚度", dict: "thickness", placeholder: "请选择或填写厚度", rules: [{ validator: b, trigger: ["change", "blur"] }], unit: "mm", decimalPlace: 3 }, { field: "plateType", name: "板型", dict: "plate_type", placeholder: "请选择或填写板型", rules: n("请选择或填写板型", 20) }, { field: "effectiveWidth", name: "有效宽度", dict: "effective_width", placeholder: "请选择或填写有效宽度", rules: [{ validator: x, trigger: ["change", "blur"] }], unit: "mm", decimalPlace: 0 }] }, { type: "外板", fields: [{ field: "outMaterial", name: "材质", dict: "out_material", placeholder: "请选择或填写材质", rules: n("请选择或填写材质", 10) }, { field: "outCoating", name: "涂层", dict: "out_coating", placeholder: "请选择或填写涂层", rules: n("请选择或填写涂层", 10) }, { field: "outPlating", name: "镀层", dict: "out_plating", placeholder: "请选择或填写镀层", rules: n("请选择或填写镀层", 20) }, { field: "outSteelPlateBrand", name: "品牌", dict: "out_steel_plate_brand", placeholder: "请选择或填写品牌", rules: n("请选择或填写品牌", 20) }, { field: "outThickness", name: "厚度", dict: "out_thickness", placeholder: "请选择或填写厚度", rules: [{ validator: b, trigger: ["change", "blur"] }], unit: "mm", decimalPlace: 3 }, { field: "outEffectiveWidth", name: "宽度", dict: "out_effective_width", placeholder: "请选择或填写宽度", rules: [{ validator: x, trigger: ["change", "blur"] }], unit: "mm", decimalPlace: 0 }, { field: "outColour", name: "颜色", dict: "out_colour", placeholder: "请选择或填写颜色", rules: n("请选择或填写颜色", 10) }, { field: "outPlateShape", name: "板形状", dict: "out_plate_shape", placeholder: "请选择或填写板形状", rules: n("请选择或填写板形状", 10) }] }, { type: "内板", fields: [{ field: "intMaterial", name: "材质", dict: "in_material", placeholder: "请选择或填写材质", rules: n("请选择或填写材质", 10) }, { field: "intCoating", name: "涂层", dict: "in_coating", placeholder: "请选择或填写涂层", rules: n("请选择或填写涂层", 10) }, { field: "intPlating", name: "镀层", dict: "in_plating", placeholder: "请选择或填写镀层", rules: n("请选择或填写镀层", 20) }, { field: "intSteelPlateBrand", name: "品牌", dict: "in_Steel_Plate_brand", placeholder: "请选择或填写品牌", rules: n("请选择或填写品牌", 20) }, { field: "intThickness", name: "厚度", dict: "in_thickness", placeholder: "请选择或填写厚度", rules: [{ validator: b, trigger: ["change", "blur"] }], unit: "mm", decimalPlace: 3 }, { field: "intEffectiveWidth", name: "宽度", dict: "in_effective_width", placeholder: "请选择或填写宽度", rules: [{ validator: x, trigger: ["change", "blur"] }], unit: "mm", decimalPlace: 0 }, { field: "intColour", name: "颜色", dict: "in_colour", placeholder: "请选择或填写颜色", rules: n("请选择或填写颜色", 10) }, { field: "intPlateShape", name: "板形状", dict: "in_plate_shape", placeholder: "请选择或填写板形状", rules: n("请选择或填写板形状", 10) }] }, { type: "芯材", fields: [{ field: "typeName", name: "种类", dict: "kind_core", placeholder: "请选择或填写种类", rules: n("请选择或填写种类", 10) }, { field: "coreBrand", name: "品牌", dict: "brand_core", placeholder: "请选择或填写品牌", rules: n("请选择或填写品牌", 20) }, { field: "unitWeight", name: "容重", dict: "unit_weight_core", placeholder: "请选择或填写容重", rules: [{ validator: M, trigger: ["change", "blur"] }], unit: "Kg/m³", decimalPlace: 2 }] }] };
  function K(o) {
    const e = k.value.find((u) => u.plateType === o);
    e && (t.value.effectiveWidth = e.effectiveWidth, t.value.unfoldedWidth = e.unfoldedWidth);
  }
  function ke(o, e, u) {
  }
  function W() {
    g.value.validate((o) => {
      if (o) {
        if (!N(t.value)) {
          de({ message: "请填写数据", type: "warning" });
          return;
        }
        if (a.value === l.TRUSS_FLOOR_PLATE.V) {
          const u = w.value.find((s) => s.code === t.value.serialNumber);
          u && u.list.map((s) => {
            t.value[s.name] = s.value;
          });
        }
        if (a.value === l.STRUCTURE.V) {
          const u = t.value.attachments && t.value.attachments.map((s) => s.id);
          t.value.attachmentIds = u ? u.join(",") : void 0;
        }
        console.log(t.value);
        const e = Object.assign({}, t.value);
        v.value[a.value].push(e), console.log(v.value[a.value]), O();
      }
    });
  }
  function Q(o) {
    L.value && W(), t.value = JSON.parse(JSON.stringify(o)), L.value = true, N(t.value.dict) || (t.value.dict = {});
  }
  async function $() {
    S.value = true;
    try {
      P.value = {}, w.value = [];
      const { content: o } = a.value !== l.STRUCTURE.V ? await ge(a.value) : h.showCategory;
      a.value !== l.TRUSS_FLOOR_PLATE.V && a.value !== l.STRUCTURE.V && o.forEach((e) => {
        P.value[e.name] = e.labels;
      }), a.value === l.PROFILED_PLATE.V || a.value === l.PRESSURE_BEARING_PLATE.V ? k.value = o.find((e) => e.name === "plate_type").plateTypeList || [] : k.value = [], w.value = a.value === l.TRUSS_FLOOR_PLATE.V ? o : [], S.value = false;
    } catch (o) {
      S.value = false, console.log(o, "获取技术交底配置");
    }
  }
  function O() {
    t.value = { dict: {}, attachments: [], attachmentIds: void 0, effectiveWidth: void 0, unfoldedWidth: void 0 }, L.value = false, g.value && g.value.resetFields(), g.value && j(() => {
      g.value.clearValidate();
    });
  }
  return G({ tableData: v }), (o, e) => {
    const u = oe, s = se, A = ce, C = fe, X = pe, Y = me, z = ie("common-button"), Z = ve, ee = _e;
    return q((d(), f("div", Ue, [_(E(ne), { modelValue: a.value, "onUpdate:modelValue": e[0] || (e[0] = (c) => a.value = c), size: "default", class: "filter-item" }, { default: p(() => [(d(true), f(V, null, T(E(l).ENUM, (c) => (d(), m(u, { key: c.V, value: c.V, disabled: h.showItem.indexOf(c.V) < 0 }, { default: p(() => [B(I(c.L) + I(v.value[c.V] && v.value[c.V].length ? `(${v.value[c.V].length})` : ""), 1)]), _: 2 }, 1032, ["value", "disabled"]))), 128))]), _: 1 }, 8, ["modelValue"]), q(_(Z, { ref_key: "formRef", ref: g, model: t.value }, { default: p(() => [(d(true), f(V, null, T(J[a.value], (c, le) => (d(), f("div", { key: le, style: { "margin-top": "10px" } }, [R("span", Pe, I(c.type), 1), R("div", we, [(d(true), f(V, null, T(c.fields, (i, ae) => (d(), m(C, { key: i.field + ae, prop: i.field, rules: i.rules ? i.rules : [] }, { default: p(() => [a.value != E(l).STRUCTURE.V && a.value != E(l).TRUSS_FLOOR_PLATE.V ? (d(), f(V, { key: 0 }, [i.field === "plateType" && a.value !== E(l).SANDWICH_BOARD.V ? (d(), m(A, { key: 0, modelValue: t.value[i.field], "onUpdate:modelValue": (r) => t.value[i.field] = r, clearable: "", size: "default", placeholder: i.name + `${i.unit ? "，单位:" + i.unit : ""}`, style: { "min-width": "120px", "margin-right": "10px" }, class: "input-underline", onChange: K }, { default: p(() => [(d(true), f(V, null, T(P.value[i.dict], (r, U) => (d(), m(s, { key: U, label: r, value: r }, null, 8, ["label", "value"]))), 128))]), _: 2 }, 1032, ["modelValue", "onUpdate:modelValue", "placeholder"])) : (d(), m(A, { key: 1, modelValue: t.value[i.field], "onUpdate:modelValue": (r) => t.value[i.field] = r, filterable: "", clearable: "", size: "default", placeholder: i.name + `${i.unit ? "，单位:" + i.unit : ""}`, style: { "min-width": "120px", "margin-right": "10px" }, class: "input-underline", onBlur: (r) => {
      i.field, i.dict;
    } }, { default: p(() => [(d(true), f(V, null, T(P.value[i.dict], (r, U) => (d(), m(s, { key: U, label: r, value: r }, null, 8, ["label", "value"]))), 128))]), _: 2 }, 1032, ["modelValue", "onUpdate:modelValue", "placeholder", "onBlur"]))], 64)) : (d(), f(V, { key: 1 }, [a.value == E(l).TRUSS_FLOOR_PLATE.V ? (d(), m(A, { key: 0, modelValue: t.value[i.field], "onUpdate:modelValue": (r) => t.value[i.field] = r, filterable: "", clearable: "", size: "default", placeholder: i.name + `${i.unit ? "，单位:" + i.unit : ""}`, style: { "min-width": "120px", "margin-right": "10px" }, class: "input-underline", onBlur: (r) => {
      i.field;
    } }, { default: p(() => [(d(true), f(V, null, T(w.value, (r, U) => (d(), m(s, { key: U, label: r.code, value: r.code }, null, 8, ["label", "value"]))), 128))]), _: 2 }, 1032, ["modelValue", "onUpdate:modelValue", "placeholder", "onBlur"])) : (d(), m(A, { key: 1, modelValue: t.value[i.field], "onUpdate:modelValue": (r) => t.value[i.field] = r, filterable: "", clearable: "", size: "default", placeholder: "产品种类", style: { "min-width": "120px", "margin-right": "10px" }, class: "input-underline", onBlur: (r) => {
      i.field;
    } }, { default: p(() => [(d(true), f(V, null, T(F.showCategory, (r) => (d(), m(s, { key: r.id, label: r.name, value: r.name }, null, 8, ["label", "value"]))), 128))]), _: 2 }, 1032, ["modelValue", "onUpdate:modelValue", "onBlur"]))], 64))]), _: 2 }, 1032, ["prop", "rules"]))), 128))])]))), 128)), a.value == E(l).STRUCTURE.V ? (d(), f("div", Le, [e[4] || (e[4] = R("div", { class: "form-title", style: { "margin-bottom": "10px" } }, "技术要求描述", -1)), _(C, { prop: "techDesc" }, { default: p(() => [_(X, { modelValue: t.value.techDesc, "onUpdate:modelValue": e[1] || (e[1] = (c) => t.value.techDesc = c), modelModifiers: { trim: true }, type: "textarea", maxlength: "2000", "show-word-limit": "", rows: "2", placeholder: "技术要求描述", style: { width: "420px" } }, null, 8, ["modelValue"])]), _: 1 }), e[5] || (e[5] = R("div", { class: "form-title", style: { "margin-bottom": "10px" } }, "附件", -1)), _(C, { prop: "techDesc" }, { default: p(() => [_(ye, { "file-classify": E(Ve).CONTRACT_ATT.V, files: t.value.attachments, "onUpdate:files": e[2] || (e[2] = (c) => t.value.attachments = c), "empty-text": "暂未上传附件", style: { width: "70%" } }, null, 8, ["file-classify", "files"])]), _: 1 })])) : (d(), f("div", Oe, [e[6] || (e[6] = R("span", { class: "form-title" }, "数量(m)", -1)), _(C, { style: { "margin-top": "10px" }, prop: "quantity" }, { default: p(() => [_(Y, { modelValue: t.value.quantity, "onUpdate:modelValue": e[3] || (e[3] = (c) => t.value.quantity = c), placeholder: "数量", size: "default", class: "input-underline", precision: 2, controls: false, clearable: "" }, null, 8, ["modelValue"])]), _: 1 })])), R("div", null, [R("span", Ae, [_(z, { size: "default", type: "success", onClick: W }, { default: p(() => e[7] || (e[7] = [B("保存继续添加")])), _: 1, __: [7] }), _(z, { size: "default", type: "warning", onClick: O }, { default: p(() => e[8] || (e[8] = [B("重置")])), _: 1, __: [8] })])])]), _: 1 }, 8, ["model"]), [[re, a.value]]), (d(), m(ue(H.value), { "table-data": v.value[a.value], "is-show": false, onEdit: Q }, null, 40, ["table-data"]))])), [[ee, S.value]]);
  };
} }, ze = he(Ce, [["__scopeId", "data-v-ed9b15c5"]]);
export {
  ze as default
};
