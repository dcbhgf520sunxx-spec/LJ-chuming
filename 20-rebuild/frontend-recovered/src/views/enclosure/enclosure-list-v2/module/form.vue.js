import { ref as y } from "vue";
import { inject as I } from "vue";
import { computed as v } from "vue";
import { watchEffect as Q } from "vue";
import { watch as R } from "vue";
import { ElMessage as k } from "element-plus";
import { resolveComponent as b } from "vue";
import { openBlock as X } from "vue";
import { createBlock as Y } from "vue";
import { withCtx as i } from "vue";
import { createVNode as o } from "vue";
import { unref as d } from "vue";
import { createTextVNode as S } from "vue";
import { createElementVNode as T } from "vue";
import { ElTableColumn as Z } from "element-plus";
import { ElInput as ee } from "element-plus";
import { ElInputNumber as le } from "element-plus";
import { ElForm as te } from "element-plus";
import { _ as ae, ao as oe, o as ne, T as A, jx as re, mj as ie, D as V, fK as ue } from "../../../../shared/runtime.js";
const de = { class: "add-row-box" }, se = { __name: "form", setup(me) {
  const U = y(), L = y(), w = y({}), O = { list: [] }, W = y({ key: "id", label: "label", value: "id" }), f = I("enclosureDictList"), C = I("technicalTypeStatus"), E = y();
  v(() => {
    var e;
    return (e = f.value) != null && e.length ? f.value.map((t) => {
      if (t.label === "压型彩板") return t.id;
    }).filter((t) => !!t)[0] : null;
  });
  const F = v(() => {
    var e;
    return (e = f.value) != null && e.length ? f.value.map((t) => {
      if (t.label === "夹芯板") return t.id;
    }).filter((t) => !!t)[0] : null;
  }), p = v(() => {
    var e;
    return (e = f.value) != null && e.length ? f.value.map((t) => {
      if (t.label === "折边件") return t.id;
    }).filter((t) => !!t)[0] : null;
  });
  Q(() => {
    console.log(p.value);
  });
  const { CRUD: $, crud: s, form: h } = oe(O, U), { maxHeight: D } = ne({ mainBox: ".detail", extraBox: [".el-drawer__header"], wrapperBox: ".table-form", paginate: true, minHeight: 300, navbar: false, clientHRepMainH: true }, E), B = { dictionaryId: [{ required: true, message: "请选择类型", trigger: "blur" }], name: [{ required: true, message: "请输入名称", trigger: "blur" }], serialNumber: [{ required: true, message: "请输入编号", trigger: "blur" }, { validator: P, message: "编号已存在，请重新输入", trigger: "blur" }], plate: [{ required: true, message: "请输入规格", trigger: "blur" }], unfoldedWidth: [{ required: true, message: "展开宽度必填", trigger: "blur" }], width: [{ validator: (e, t) => t.dictionaryId === p.value || !!t.width, message: "有效宽度必填", trigger: "change" }], thickness: [{ required: true, message: "厚度必填", trigger: "blur" }], bendTimes: [{ validator: (e, t) => t.dictionaryId !== p.value || !!t.bendTimes, message: "折弯次数", trigger: "blur" }], length: [{ required: true, message: "单长必填", trigger: "blur" }], unit: [{ required: true, message: "计量单位必填", trigger: "change" }], quantity: [{ required: true, message: "数量必填", trigger: "change" }], accountingVolume: [{ required: true, message: "核算量必填", trigger: "change" }], surfaceArea: [{ required: true, message: "单面积必填", trigger: "change" }] }, M = v(() => ({ ...B, ...{} }));
  R(() => s.query.category, () => {
    q();
  }, { immediate: true }), R(() => C.value, () => {
    q();
  }, { immediate: true });
  async function q() {
    if (w.value = {}, !(C.value || !s.query.category || s.query.category === A.BENDING.V)) try {
      const { content: e = [] } = await re(s.query.category) || {}, t = {};
      s.query.category === A.TRUSS_FLOOR_PLATE.V ? w.value.plate_type = e.map((r) => {
        let a = "";
        return r == null || r.list.forEach((m) => {
          m.name === "effectiveWidth" && (a = m.value);
        }), t[r.code] = { effectiveWidth: a }, { name: r.code };
      }) : e.forEach((r) => {
        r.name === "plate_type" && ((r.plateTypeList || []).forEach((a) => {
          t[a.plateType] = a;
        }), w.value[r.name] = (r.labels || []).map((a) => ({ name: a })));
      }), w.value.KV = t;
    } catch (e) {
      console.log("获取围护配置信息列表", e);
    }
  }
  function j({ row: e, column: t }) {
    if (!e) return;
    const r = M.value;
    let a = true;
    return e.verify && Object.keys(e.verify) && Object.keys(e.verify).length > 0 && (e.verify[t.property] === false && (a = ue(t.property, r[t.property], e)), a && (e.verify[t.property] = true)), a ? "" : "mask-td";
  }
  function z(e) {
    h.list.splice(e, 1);
  }
  function H() {
    h.list.push({ areaId: s.query.areaId });
  }
  function _(e) {
    N(e);
  }
  function K(e) {
    N(e);
  }
  $.HOOK.beforeValidateCU = (e, t) => {
    if (e.form.list.length <= 0) return k({ message: "请先添加围护信息", type: "error" }), false;
    const r = M.value;
    let a = true, m = "";
    if (e.form.list.map((u) => {
      u.verify = {};
      for (const g in r) {
        const { valid: c, message: x } = ie(g, r[g], u);
        u.verify[g] = c, u.verify[g] || (m = x || "请填写表格中标红数据", a = false);
      }
    }), !a) return k.error(m), false;
    if (e.form.list.forEach((u) => {
      delete u.verify;
    }), !e.query.areaId) return k({ message: "无区域信息不予提交", type: "error" }), false;
    e.form.areaId = e.query.areaId;
  };
  function ce(e) {
  }
  function N(e) {
    const { unfoldedWidth: t, thickness: r, length: a, quantity: m, width: u } = e;
    t != null && r !== void 0 && r !== null && a !== void 0 && a !== null ? e.dictionaryId !== F.value ? (e.weight = t * r * a * 7.85 / 1e6, e.weight = Number(e.weight.toFixed(5))) : e.weight = 0 : e.weight = null, a != null && m !== void 0 && m !== null ? (e.accountingVolume = a * m / 1e3, e.accountingVolume = e.accountingVolume.toFixed(2)) : e.accountingVolume = null, e.dictionaryId === p.value ? t != null && a !== void 0 && a !== null ? (e.surfaceArea = t * a / 1e6, e.surfaceArea = e.surfaceArea.toFixed(4)) : e.surfaceArea = null : u != null && a !== void 0 && a !== null ? (e.surfaceArea = u * a / 1e6, e.surfaceArea = e.surfaceArea.toFixed(4)) : e.surfaceArea = null;
  }
  function P(e, t) {
    return t.serialNumber ? h.list.filter((a) => a.serialNumber === t.serialNumber && a !== t).length === 0 : true;
  }
  return (e, t) => {
    const r = b("common-button"), a = Z, m = b("common-select"), u = ee, g = b("table-cell-tag"), c = le, x = b("common-table"), G = te, J = b("common-drawer");
    return X(), Y(J, { ref_key: "drawerRef", ref: E, "before-close": d(s).cancelCU, "close-on-click-modal": false, title: d(s).status.title, visible: d(s).status.cu > 0, "wrapper-closable": false, "append-to-body": "", "custom-class": "detail", size: "100%" }, { titleRight: i(() => [o(r, { loading: d(s).status.cu === 2, size: "default", type: "primary", onClick: d(s).submitCU }, { default: i(() => t[1] || (t[1] = [S("确认 ")])), _: 1, __: [1] }, 8, ["loading", "onClick"])]), content: i(() => [o(G, { ref_key: "formRef", ref: U, model: d(h), "label-width": "140px", size: "default" }, { default: i(() => [o(x, { ref_key: "detailRef", ref: L, "cell-class-name": j, data: d(h).list, "max-height": d(D) - 150, showEmptySymbol: false, border: "", class: "table-form", "return-source-data": "", style: { width: "100%" } }, { default: i(() => [o(a, { align: "center", fixed: "left", label: "序号", type: "index", width: "55" }), o(a, { key: "dictionaryId", align: "center", label: "类型", prop: "dictionaryId" }, { default: i(({ row: l }) => [o(m, { modelValue: l.dictionaryId, "onUpdate:modelValue": (n) => l.dictionaryId = n, "data-structure": W.value, options: d(f), clearable: "", filterable: "", size: "default", onChange: (n) => void 0 }, null, 8, ["modelValue", "onUpdate:modelValue", "data-structure", "options", "onChange"])]), _: 1 }), o(a, { key: "name", "show-overflow-tooltip": true, label: "名称", "min-width": "100", prop: "name" }, { default: i((l) => [o(u, { modelValue: l.row.name, "onUpdate:modelValue": (n) => l.row.name = n, placeholder: "名称", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), o(a, { key: "serialNumber", "show-overflow-tooltip": true, align: "center", label: "编号", "min-width": "90px", prop: "serialNumber" }, { header: i(() => [t[2] || (t[2] = T("span", null, "编号", -1)), o(g, { offset: 15, color: "#e64242", name: "唯一" })]), default: i((l) => [o(u, { modelValue: l.row.serialNumber, "onUpdate:modelValue": (n) => l.row.serialNumber = n, placeholder: "编号", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), o(a, { key: "plate", "show-overflow-tooltip": true, label: "规格", "min-width": "90px", prop: "plate" }, { default: i((l) => [o(u, { modelValue: l.row.plate, "onUpdate:modelValue": (n) => l.row.plate = n, placeholder: "规格", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), o(a, { label: `展开宽度
(mm)`, "show-overflow-tooltip": true, "min-width": "100px", prop: "unfoldedWidth" }, { default: i((l) => [o(c, { modelValue: l.row.unfoldedWidth, "onUpdate:modelValue": (n) => l.row.unfoldedWidth = n, modelModifiers: { number: true }, max: 9999999999, min: 0, precision: d(V).MES_ENCLOSURE_W__MM, step: 1, "controls-position": "right", placeholder: "展开宽度", style: { width: "100%" }, onChange: (n) => _(l.row) }, null, 8, ["modelValue", "onUpdate:modelValue", "precision", "onChange"])]), _: 1 }), o(a, { key: "width", label: `有效宽度
(mm)`, "show-overflow-tooltip": true, "min-width": "100px", prop: "width" }, { default: i((l) => [o(c, { modelValue: l.row.width, "onUpdate:modelValue": (n) => l.row.width = n, modelModifiers: { number: true }, disabled: l.row.dictionaryId === p.value, max: 9999999999, min: 0, precision: d(V).MES_ENCLOSURE_W__MM, step: 1, "controls-position": "right", label: "有效宽度", placeholder: "有效宽度", style: { width: "100%" }, onChange: (n) => _(l.row) }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "precision", "onChange"])]), _: 1 }), o(a, { key: "thickness", label: `厚度
(mm)`, "show-overflow-tooltip": true, align: "left", "min-width": "100px", prop: "thickness" }, { default: i((l) => [o(c, { modelValue: l.row.thickness, "onUpdate:modelValue": (n) => l.row.thickness = n, modelModifiers: { number: true }, max: 9999999999, min: 0, precision: d(V).MES_ENCLOSURE_T__MM, step: 1, "controls-position": "right", placeholder: "厚度", style: { width: "100%" }, onChange: (n) => K(l.row) }, null, 8, ["modelValue", "onUpdate:modelValue", "precision", "onChange"])]), _: 1 }), o(a, { key: "length", label: `单长
(㎜)`, "show-overflow-tooltip": true, align: "left", "min-width": "100px", prop: "length" }, { default: i((l) => [o(c, { modelValue: l.row.length, "onUpdate:modelValue": (n) => l.row.length = n, modelModifiers: { number: true }, max: 9999999999, min: 0, precision: d(V).MES_ENCLOSURE_L__MM, step: 1, "controls-position": "right", placeholder: "单长", style: { width: "100%" }, onChange: (n) => _(l.row) }, null, 8, ["modelValue", "onUpdate:modelValue", "precision", "onChange"])]), _: 1 }), o(a, { key: "unit", "show-overflow-tooltip": true, align: "left", label: "计量单位", "min-width": "100px", prop: "unit" }, { default: i((l) => [o(u, { modelValue: l.row.unit, "onUpdate:modelValue": (n) => l.row.unit = n, placeholder: "计量单位", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), o(a, { key: "bendTimes", align: "left", label: "折弯次数", prop: "bendTimes" }, { default: i(({ row: l }) => [o(u, { modelValue: l.bendTimes, "onUpdate:modelValue": (n) => l.bendTimes = n, disabled: l.dictionaryId !== p.value, placeholder: "折弯次数", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled"])]), _: 1 }), o(a, { key: "quantity", label: "数量(张)", align: "left", "min-width": "100px", prop: "quantity" }, { default: i((l) => [o(c, { modelValue: l.row.quantity, "onUpdate:modelValue": (n) => l.row.quantity = n, modelModifiers: { number: true }, max: 9999999999, min: 0, precision: d(V).MES_ENCLOSURE_L__MM, step: 1, "controls-position": "right", placeholder: "数量", style: { width: "100%" }, onChange: (n) => _(l.row) }, null, 8, ["modelValue", "onUpdate:modelValue", "precision", "onChange"])]), _: 1 }), o(a, { key: "accountingVolume", label: "核算量(米)", align: "left", "min-width": "100px", prop: "accountingVolume" }, { default: i((l) => [o(c, { modelValue: l.row.accountingVolume, "onUpdate:modelValue": (n) => l.row.accountingVolume = n, modelModifiers: { number: true }, max: 9999999999, min: 0, step: 1, "controls-position": "right", disabled: "", placeholder: "核算量", style: { width: "100%" }, onChange: (n) => _(l.row) }, null, 8, ["modelValue", "onUpdate:modelValue", "onChange"])]), _: 1 }), o(a, { key: "surfaceArea", "show-overflow-tooltip": true, align: "left", label: "单面积(m²)", "min-width": "100px", prop: "surfaceArea" }, { default: i((l) => [o(u, { modelValue: l.row.surfaceArea, "onUpdate:modelValue": (n) => l.row.surfaceArea = n, disabled: "", placeholder: "单面积", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), o(a, { key: "weight", align: "left", label: "单重量(kg)", "min-width": "100px", prop: "weight" }, { default: i((l) => [o(u, { modelValue: l.row.weight, "onUpdate:modelValue": (n) => l.row.weight = n, disabled: "", placeholder: "单重量", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), o(a, { key: "remark", "show-overflow-tooltip": true, label: "备注", "min-width": "100px", prop: "remark" }, { default: i((l) => [o(u, { modelValue: l.row.remark, "onUpdate:modelValue": (n) => l.row.remark = n, placeholder: "备注", style: { width: "100%" }, type: "textarea" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), o(a, { align: "center", fixed: "right", label: "操作" }, { default: i((l) => [o(r, { icon: "el-icon-delete", size: "default", type: "danger", onClick: (n) => z(l.$index) }, null, 8, ["onClick"])]), _: 1 })]), _: 1 }, 8, ["data", "max-height"]), T("div", de, [o(r, { icon: "el-icon-circle-plus", size: "default", style: { "margin-right": "15px" }, type: "warning", onClick: t[0] || (t[0] = (l) => H()) }, { default: i(() => t[3] || (t[3] = [S(" 继续添加 ")])), _: 1, __: [3] })])]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["before-close", "title", "visible"]);
  };
} }, ge = ae(se, [["__scopeId", "data-v-85267eb7"]]);
export {
  ge as default
};
