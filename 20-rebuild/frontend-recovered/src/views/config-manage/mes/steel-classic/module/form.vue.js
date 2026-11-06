import { computed as h } from "vue";
import { ref as _ } from "vue";
import { ElMessage as g } from "element-plus";
import { nextTick as E } from "vue";
import { resolveComponent as b } from "vue";
import { openBlock as u } from "vue";
import { createBlock as c } from "vue";
import { withCtx as s } from "vue";
import { createVNode as i } from "vue";
import { unref as l } from "vue";
import { createTextVNode as C } from "vue";
import { createElementVNode as L } from "vue";
import { toDisplayString as D } from "vue";
import { createElementBlock as ce } from "vue";
import { Fragment as pe } from "vue";
import { renderList as _e } from "vue";
import { withKeys as ye } from "vue";
import { createCommentVNode as Ce } from "vue";
import { ElFormItem as ge } from "element-plus";
import { ElTag as Ee } from "element-plus";
import { ElInput as be } from "element-plus";
import { ElInputNumber as ke } from "element-plus";
import { ElDivider as Te } from "element-plus";
import { ElTableColumn as we } from "element-plus";
import { ElForm as xe } from "element-plus";
import { _ as ve, eu as N, f9 as m, am as I, ao as Pe, o as Ve, V as Oe, av as he, aw as Le, i as K } from "../../../../../shared/runtime.js";
import { u as De } from "../../../../../modules/use-section-all-504a2069.js";
const Ne = { class: "detail-header" }, Ie = { style: { "text-align": "center", "margin-top": "10px" } }, Se = { __name: "form", props: { boundAllClassifyIds: { type: Array, default: () => {
} } }, setup(B) {
  const { loaded: S, partSectionAll: x } = De(), M = h(() => {
    var e, o;
    return ((o = (e = x.value[N.PRODUCT_TYPE_ENUM.V]) == null ? void 0 : e.find((r) => Number(r.productClassificationEnum) === m.STEEL_PLATE_PRODUCT.V)) == null ? void 0 : o.sectionWarehouseConfigDTOList) || [];
  }), $ = h(() => {
    var e, o;
    return ((o = (e = x.value[N.PRODUCT_TYPE_ENUM.V]) == null ? void 0 : e.find((r) => Number(r.productClassificationEnum) === m.SECTION_PRODUCT.V)) == null ? void 0 : o.sectionWarehouseConfigDTOList) || [];
  }), F = h(() => {
    var e, o;
    return ((o = (e = x.value[N.SECTION_TYPE_ENUM.V]) == null ? void 0 : e.find((r) => Number(r.productClassificationEnum) === m.SECTION_PRODUCT.V)) == null ? void 0 : o.sectionWarehouseConfigDTOList) || [];
  }), H = B, U = _(), f = _([]), R = _(), v = _([]), P = _(false), y = _(), q = { 0: { L: "全部", K: "0", V: 0 }, 1: { L: "1", K: "1", V: 1 }, 2: { L: "2", K: "2", V: 2 }, 3: { L: "3", K: "3", V: 3 }, 4: { L: "4", K: "4", V: 4 } }, W = { id: void 0, name: "", basicClass: I.STEEL_PLATE.V, productClassificationEnum: m.STEEL_PLATE_PRODUCT.V, sort: void 0, links: [], steelClassNamePrefixDTOParams: [] }, { crud: d, form: t, CRUD: k } = Pe(W, U), { maxHeight: Y } = Ve({ extraBox: [".el-drawer__header", ".detail-header"], wrapperBox: [".el-drawer__body"], navbar: false, extraHeight: 120 }, () => R.value.loaded), j = { keyword: [{ required: true, message: "请选择大写字母", trigger: "change" }], specIndex: [{ validator: (a, e) => !!K(a), message: "请选择索引", trigger: "blur" }] }, { tableValidate: G, wrongCellMask: J } = Le({ rules: j }), Q = { productClassificationEnum: [{ required: true, message: "请选择类型", trigger: "change" }], name: [{ required: true, message: "请填写分类名称", trigger: "change" }], steelClassNamePrefixDTOParams: [{ required: true, message: "请输入匹配名称", trigger: "blur" }], sort: [{ required: true, message: "请填写排序值", trigger: "blur", type: "number" }] }, X = _([m.STEEL_PLATE_PRODUCT, m.SECTION_PRODUCT]);
  function Z(a) {
    t.basicClass = a === m.STEEL_PLATE_PRODUCT.V ? I.STEEL_PLATE.V : I.SECTION_STEEL.V, t.name = void 0, t.sort = void 0, t.links = [], t.steelClassNamePrefixDTOParams = [];
  }
  function ee() {
    t.links.push({ add: true, specIndex: 0 });
  }
  function ae(a) {
    t.links.splice(a, 1);
  }
  function le(a, e) {
    a.keyword = void 0;
    const o = f.value.findIndex((r) => r.index === e);
    f.value.splice(o, 1);
  }
  function te(a, e) {
    const o = f.value.find((r) => r.index === e);
    if (o) if (a.keyword) {
      if (o.keyword === a.keyword) return;
      f.value.findIndex((r) => r.keyword === a.keyword) > -1 ? (g({ message: "关键字母已存在，请重新填写", type: "error" }), E(() => {
        t.links[e].keyword = void 0, o.keyword = void 0;
      })) : E(() => {
        o.keyword = a.keyword;
      });
    } else E(() => {
      o.keyword = void 0;
    });
    else a.keyword && (f.value.findIndex((r) => r.keyword === a.keyword) > -1 && (g({ message: "关键字母已存在，请重新填写", type: "error" }), E(() => {
      a.keyword = void 0;
    })), a.keyword && f.value.push({ keyword: a.keyword, index: e }));
  }
  function ne() {
    P.value = false, y.value = void 0;
  }
  function oe(a) {
    if (d.form.steelClassNamePrefixDTOParams.splice(d.form.steelClassNamePrefixDTOParams.indexOf(a), 1), d.form.steelClassNamePrefixDTOParams.length === 0) {
      g.warning("至少保留一条数据");
      return;
    }
  }
  function se() {
    P.value = true;
  }
  function A() {
    var a, e;
    if ((a = d.form.steelClassNamePrefixDTOParams) != null && a.includes(y.value)) {
      g.warning("名称已存在");
      return;
    }
    K(y.value) && ((e = d.form.steelClassNamePrefixDTOParams) == null || e.push(y.value)), ne();
  }
  return k.HOOK.beforeSubmit = (a, e) => {
    if (a.form.links && a.form.links.length === 0) return g.error("请填写零件规格前缀明细"), false;
    const { validResult: o, dealList: r } = G(a.form.links);
    if (o) a.form.links = r, a.form.mesProductEnum = a.query.mesProductEnum;
    else return o;
  }, k.HOOK.beforeToAdd = () => {
    f.value = [];
  }, k.HOOK.beforeToEdit = () => {
    f.value = [], t.links.map((a, e) => {
      f.value.push({ keyword: a.keyword, index: e });
    });
  }, k.HOOK.beforeToCU = () => {
    E(() => {
      v.value = Oe(H.boundAllClassifyIds), t.classifyIds && t.classifyIds.forEach((a) => {
        const e = v.value.indexOf(a);
        e !== -1 && v.value.splice(e, 1);
      });
    });
  }, (a, e) => {
    const o = b("common-button"), r = b("common-radio"), T = ge, V = Ee, O = b("common-select"), re = be, ie = ke, de = Te, w = we, ue = b("common-table"), me = xe, fe = b("common-drawer");
    return u(), c(fe, { "append-to-body": "", "close-on-click-modal": false, "before-close": l(d).cancelCU, visible: l(d).status.cu > 0, title: l(d).status.title, "wrapper-closable": false, ref_key: "drawerRef", ref: R, size: "60%" }, { titleRight: s(() => [i(o, { loading: l(d).status.cu === 2, type: "primary", size: "default", onClick: l(d).submitCU }, { default: s(() => e[5] || (e[5] = [C("确认")])), _: 1, __: [5] }, 8, ["loading", "onClick"])]), content: s(() => [i(me, { ref_key: "formRef", ref: U, model: l(t), rules: Q, size: "default", class: "tax-setting", "label-width": "140px" }, { default: s(() => {
      var z;
      return [L("div", Ne, [i(T, { label: "类型", prop: "productClassificationEnum" }, { default: s(() => [i(r, { modelValue: l(t).productClassificationEnum, "onUpdate:modelValue": e[0] || (e[0] = (n) => l(t).productClassificationEnum = n), options: X.value, type: "enumSL", size: "default", onChange: Z }, null, 8, ["modelValue", "options"])]), _: 1 }), i(T, { label: "名称", prop: "name" }, { default: s(() => [l(t).name ? (u(), c(V, { key: 0, style: { "margin-right": "3px", "margin-bottom": "3px" }, closable: "", "disable-transitions": false, size: "large", effect: "plain", onClose: e[1] || (e[1] = (n) => l(t).name = void 0) }, { default: s(() => [C(D(l(t).name), 1)]), _: 1 })) : (u(), c(O, { key: 1, modelValue: l(t).name, "onUpdate:modelValue": e[2] || (e[2] = (n) => l(t).name = n), options: l(t).productClassificationEnum === l(m).STEEL_PLATE_PRODUCT.V ? M.value : $.value, type: "other", size: "default", class: "filter-item", dataStructure: { key: "name", label: "name", value: "name" }, placeholder: "名称", style: { width: "250px" }, disabled: !l(S) }, null, 8, ["modelValue", "options", "disabled"]))]), _: 1 }), (z = l(t).name) != null && z.includes("翼腹板") ? (u(), c(T, { key: 0, label: "匹配名称", prop: "steelClassNamePrefixDTOParams" }, { default: s(() => [(u(true), ce(pe, null, _e(l(t).steelClassNamePrefixDTOParams, (n, p) => (u(), c(V, { size: "large", key: p, closable: "", "disable-transitions": false, onClose: (Re) => oe(n) }, { default: s(() => [C(D(n), 1)]), _: 2 }, 1032, ["onClose"]))), 128)), P.value ? (u(), c(re, { key: 0, class: "input-new-tag", ref: "inputRef", modelValue: y.value, "onUpdate:modelValue": e[3] || (e[3] = (n) => y.value = n), modelModifiers: { trim: true }, type: "text", placeholder: "名称", onKeyup: ye(A, ["enter"]), onBlur: A, maxlength: "10" }, null, 8, ["modelValue"])) : (u(), c(o, { key: 1, class: "button-new-tag", icon: "el-icon-plus", size: "default", onClick: se }, { default: s(() => e[6] || (e[6] = [C("添加")])), _: 1, __: [6] }))]), _: 1 })) : Ce("", true), i(T, { label: "排序", prop: "sort" }, { default: s(() => [i(ie, { modelValue: l(t).sort, "onUpdate:modelValue": e[4] || (e[4] = (n) => l(t).sort = n), modelModifiers: { number: true }, min: 1, max: 999, step: 1, "controls-position": "right", style: { width: "270px" } }, null, 8, ["modelValue"])]), _: 1 }), i(de, null, { default: s(() => e[7] || (e[7] = [L("span", { class: "title" }, "零件规格前缀明细", -1)])), _: 1, __: [7] })]), i(ue, { ref: "detailRef", border: "", data: l(t).links, "max-height": l(Y), style: { width: "100%", "margin-top": "10px" }, class: "table-form", "return-source-data": "", showEmptySymbol: false, "cell-class-name": l(J) }, { default: s(() => [i(w, { label: "序号", type: "index", align: "center", width: "55" }), i(w, { key: "keyword", prop: "keyword", label: "*大写字母", align: "center" }, { default: s((n) => [n.row.keyword ? (u(), c(V, { key: 0, style: { "margin-right": "3px", "margin-bottom": "3px" }, closable: "", "disable-transitions": false, size: "large", effect: "plain", onClose: (p) => le(n.row, n.$index) }, { default: s(() => [C(D(n.row.keyword), 1)]), _: 2 }, 1032, ["onClose"])) : (u(), c(O, { key: 1, modelValue: n.row.keyword, "onUpdate:modelValue": (p) => n.row.keyword = p, options: l(t).productClassificationEnum === l(m).STEEL_PLATE_PRODUCT.V ? [l(he).PL] : F.value, type: l(t).productClassificationEnum === l(m).STEEL_PLATE_PRODUCT.V ? "enum" : "other", size: "default", class: "filter-item", dataStructure: { key: "name", label: "name", value: "name" }, placeholder: "截面", style: { width: "250px" }, onChange: (p) => te(n.row, n.$index), disabled: !l(S) }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "type", "onChange", "disabled"]))]), _: 1 }), i(w, { key: "specIndex", prop: "specIndex", label: "*索引", align: "center" }, { default: s((n) => [i(O, { modelValue: n.row.specIndex, "onUpdate:modelValue": (p) => n.row.specIndex = p, options: q, type: "enum", size: "default", clearable: "", class: "filter-item", placeholder: "索引", disabled: true }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), i(w, { label: "操作", align: "center" }, { default: s((n) => [i(o, { size: "default", icon: "el-icon-delete", type: "danger", onClick: (p) => ae(n.$index) }, null, 8, ["onClick"])]), _: 1 })]), _: 1 }, 8, ["data", "max-height", "cell-class-name"]), L("div", Ie, [i(o, { size: "default", type: "success", onClick: ee }, { default: s(() => e[8] || (e[8] = [C("添加")])), _: 1, __: [8] })])];
    }), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["before-close", "visible", "title"]);
  };
} }, Be = ve(Se, [["__scopeId", "data-v-3a5d1ae4"]]);
export {
  Be as default
};
