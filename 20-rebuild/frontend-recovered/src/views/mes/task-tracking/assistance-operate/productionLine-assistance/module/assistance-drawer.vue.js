import { ref as y } from "vue";
import { inject as se } from "vue";
import { resolveComponent as j } from "vue";
import { resolveDirective as ke } from "vue";
import { openBlock as r } from "vue";
import { createBlock as u } from "vue";
import { withCtx as i } from "vue";
import { unref as t } from "vue";
import { createTextVNode as M } from "vue";
import { toDisplayString as w } from "vue";
import { createCommentVNode as h } from "vue";
import { withDirectives as F } from "vue";
import { createElementVNode as _ } from "vue";
import { createVNode as o } from "vue";
import { withKeys as re } from "vue";
import { withModifiers as ue } from "vue";
import { normalizeStyle as K } from "vue";
import { isRef as Ie } from "vue";
import { ElMessage as xe } from "element-plus";
import { ElTag as Ce } from "element-plus";
import { ElInput as Ee } from "element-plus";
import { ElTableColumn as Ae } from "element-plus";
import { ElCascader as Re } from "element-plus";
import { ElDivider as Me } from "element-plus";
import { ElInputNumber as Ne } from "element-plus";
import { vLoading as qe } from "element-plus";
import { d as Le } from "../../../../../../modules/productionLine-assistance-be4814e6.js";
import { _ as He, u as Ue, o as De, rL as f, aw as pe, c9 as Pe } from "../../../../../../shared/runtime.js";
import { m as de } from "../../../../../../modules/use-scheduling-groups-e49a6ba2.js";
import Se from "./assistance-preview.vue.js";
import "../../../../../../modules/artifact-f1b0ca44.js";
const Be = { class: "head-container" }, Qe = { __name: "assistance-drawer", props: { visible: { type: Boolean, default: false }, info: { type: Object, default: () => {
} } }, emits: ["update:visible", "success"], setup(N, { emit: ce }) {
  const $ = y(), J = ce, E = N, { visible: z, handleClose: X } = Ue({ emit: J, props: E, field: "visible", showHook: ne }), { maxHeight: q } = De({ extraBox: [".el-drawer__header", ".tip", ".head-container"], wrapperBox: [".el-drawer__body"], navbar: false, clientHRepMainH: true }, $), Y = y([["askCompleteTime", ["parse-time", "{y}-{m}-{d}"]]]), p = se("crud"), me = se("permission"), A = y({}), W = y([]), G = y([]), L = y(false), V = y({}), Z = y([]), T = y([]), k = y([]), H = y([]), U = y([]), D = y([]), O = y(false), fe = { numbersMap: [{ required: true, message: "请选择一物一码", trigger: "change" }], groupsId: [{ required: true, message: "请选择生产组", trigger: "change" }] }, ge = { maxQuantity: [{ required: true, message: "请填写数量", trigger: "blur" }, { pattern: Pe, message: "数量必须大于0", trigger: "blur" }], groupsId: [{ required: true, message: "请选择生产组", trigger: "change" }] }, ee = /* @__PURE__ */ new Map([["groupsId", "同上"]]), { tableValidate: te, cleanUpData: le, wrongCellMask: he } = pe({ rules: fe, ditto: ee }), { tableValidate: ae, cleanUpData: oe, wrongCellMask: be } = pe({ rules: ge, ditto: ee });
  function ne() {
    A.value = {}, P();
  }
  function ye(d) {
    T.value = d;
  }
  function ve(d) {
    k.value = d;
  }
  function we(d) {
    return d.numbers.length && d.canCollabQuantity;
  }
  function _e(d) {
    return d.canCollabQuantity;
  }
  function ie(d, a, c) {
    c !== 0 && !d && (a.groupsId = "同上");
  }
  async function P() {
    var d, a, c, g, s, l, I, m, x, S, B, Q;
    try {
      L.value = true, W.value = [], G.value = [], V.value = {};
      const { content: R } = await Le({ taskOrderId: (d = E.info) == null ? void 0 : d.id, ...A.value });
      for (let C = 0; C < R.length; C++) {
        const e = R[C];
        if (e.attributeType = e.taskTypeEnum === f.ASSEMBLE.V ? "部件" : "套料", e.editQuantity = e.quantity, e.numbersArr = (a = e.numbers) == null ? void 0 : a.map((n) => ({ id: n, label: n })), !V.value[e.configId]) {
          let n = {};
          p.query.taskTypeEnum === f.MACHINE_PART.V ? n = await de({ productType: p.query.taskTypeEnum, disabledIds: ((c = e == null ? void 0 : e.groups) == null ? void 0 : c.id) && [(g = e == null ? void 0 : e.groups) == null ? void 0 : g.id] || [] }) : n = await de({ productType: p.query.taskTypeEnum, structureClassId: e.configId, disabledIds: ((l = (s = E.info) == null ? void 0 : s.groups) == null ? void 0 : l.id) && [(m = (I = E.info) == null ? void 0 : I.groups) == null ? void 0 : m.id] || [], _factoryIds: ((S = (x = E.info) == null ? void 0 : x.factory) == null ? void 0 : S.id) && [(Q = (B = E.info) == null ? void 0 : B.factory) == null ? void 0 : Q.id] || [] }), V.value[e.configId] = n;
        }
        C > 0 && (e.groupsId = "同上"), e.boolOneCode && W.value.push(e), e.boolOneCode || G.value.push(e);
      }
    } catch (R) {
      console.log("可变更的任务工单详情列表获取失败", R);
    } finally {
      L.value = false;
    }
  }
  function Ve() {
    var d;
    if (Z.value = [...T.value, ...k.value], !((d = Z.value) != null && d.length)) {
      xe.warning("请至少选择一条数据");
      return;
    }
    if (T.value.length > 0 && k.value.length === 0) {
      const a = T.value.map((s) => s), { validResult: c, dealList: g } = te(a);
      if (c) le(g), U.value = g.map((s, l) => ({ ...s, assistance: { ...V.value[s.configId].obj[s.groupsId] } }));
      else return c;
      H.value = U.value;
    }
    if (k.value.length > 0 && T.value.length === 0) {
      const a = k.value.map((s) => s), { validResult: c, dealList: g } = ae(a);
      if (c) oe(g), D.value = g.map((s, l) => ({ ...s, assistance: { ...V.value[s.configId].obj[s.groupsId] } }));
      else return c;
      H.value = D.value;
    }
    if (T.value.length > 0 && k.value.length > 0) {
      const a = T.value.map((m) => m), { validResult: c, dealList: g } = te(a);
      if (c) le(g), U.value = g.map((m, x) => ({ ...m, assistance: { ...V.value[m.configId].obj[m.groupsId] } }));
      else return c;
      const s = k.value.map((m) => m), { validResult: l, dealList: I } = ae(s);
      if (l) oe(I), D.value = I.map((m, x) => ({ ...m, assistance: { ...V.value[m.configId].obj[m.groupsId] } }));
      else return l;
      H.value = [...U.value, ...D.value];
    }
    O.value = true;
  }
  function Te() {
    X(), J("success");
  }
  return (d, a) => {
    const c = Ce, g = j("common-button"), s = Ee, l = Ae, I = j("common-select"), m = Re, x = j("common-table"), S = Me, B = Ne, Q = j("common-drawer"), R = ke("permission"), C = qe;
    return r(), u(Q, { ref_key: "drawerRef", ref: $, title: "产线协同", modelValue: t(z), "onUpdate:modelValue": a[3] || (a[3] = (e) => Ie(z) ? z.value = e : null), direction: "rtl", "before-close": t(X), size: "80%" }, { titleAfter: i(() => [t(p).query.taskTypeEnum !== t(f).MACHINE_PART.V ? (r(), u(c, { key: 0, effect: "plain" }, { default: i(() => {
      var e, n, b;
      return [M(" 原生产组：" + w((e = N.info.workshop) == null ? void 0 : e.name) + ">" + w((n = N.info.productionLine) == null ? void 0 : n.name) + ">" + w((b = N.info.groups) == null ? void 0 : b.name), 1)];
    }), _: 1 })) : h("", true)]), titleRight: i(() => [F((r(), u(g, { size: "default", type: "primary", onClick: Ve }, { default: i(() => a[4] || (a[4] = [M("预览并保存")])), _: 1, __: [4] })), [[R, t(me).save]])]), content: i(() => [a[8] || (a[8] = _("div", { class: "tip" }, [_("span", null, "* 提示："), _("span", null, " 产线协同只能对未开始生产的构件或部件或零件进行协同，已经开始生产无法协同")], -1)), _("div", Be, [o(s, { modelValue: A.value.serialNumber, "onUpdate:modelValue": a[0] || (a[0] = (e) => A.value.serialNumber = e), size: "default", placeholder: "输入编号搜索", style: { width: "170px" }, class: "filter-item", clearable: "", onKeyup: re(P, ["enter"]) }, null, 8, ["modelValue"]), o(s, { modelValue: A.value.specification, "onUpdate:modelValue": a[1] || (a[1] = (e) => A.value.specification = e), size: "default", placeholder: "输入规格搜索", style: { width: "170px" }, class: "filter-item", clearable: "", onKeyup: re(P, ["enter"]) }, null, 8, ["modelValue"]), o(g, { class: "filter-item", size: "default", type: "success", icon: "el-icon-search", onClick: ue(P, ["stop"]) }, { default: i(() => a[5] || (a[5] = [M("搜索")])), _: 1, __: [5] }), o(g, { class: "filter-item", size: "default", type: "warning", icon: "el-icon-refresh-left", onClick: ue(ne, ["stop"]) }, { default: i(() => a[6] || (a[6] = [M(" 重置 ")])), _: 1, __: [6] })]), _("div", { style: K(`display: flex; flex-direction: column;height: ${t(q)}px;`) }, [_("div", { style: K(`height: ${t(q) / 2}px;`) }, [F((r(), u(x, { data: W.value, "max-height": t(q), "cell-class-name": t(he), "data-format": Y.value, onSelectionChange: ye, style: { width: "100%" } }, { default: i(() => [o(l, { type: "selection", width: "55", align: "center", selectable: we }), o(l, { label: "序号", type: "index", align: "center", width: "60" }), t(p).query.taskTypeEnum !== t(f).MACHINE_PART.V ? (r(), u(l, { key: 0, prop: "area.name", "show-overflow-tooltip": true, label: "区域", "min-width": "100px", align: "center" })) : h("", true), t(p).query.taskTypeEnum === t(f).MACHINE_PART.V ? (r(), u(l, { key: 1, prop: "cutNumber", "show-overflow-tooltip": true, label: "切割指令号", "min-width": "100px", align: "center" })) : h("", true), t(p).query.taskTypeEnum === t(f).ASSEMBLE.V ? (r(), u(l, { key: 2, prop: "attributeType", "show-overflow-tooltip": true, label: "属性", width: "90", align: "center" }, { default: i(({ row: e }) => [o(c, { type: e.attributeType === "部件" ? "warning" : "success" }, { default: i(() => [M(w(e.attributeType), 1)]), _: 2 }, 1032, ["type"])]), _: 1 })) : h("", true), t(p).query.taskTypeEnum !== t(f).MACHINE_PART.V ? (r(), u(l, { key: 3, prop: "serialNumber", "show-overflow-tooltip": true, label: "编号", "min-width": "100px", align: "center" })) : h("", true), o(l, { prop: "specification", "show-overflow-tooltip": true, label: "规格", "min-width": "100px", align: "center" }), o(l, { prop: "totalNetWeight", "show-overflow-tooltip": true, label: "总净重", align: "center" }), o(l, { prop: "totalGrossWeight", "show-overflow-tooltip": true, label: "总毛重", align: "center" }), t(p).query.taskTypeEnum !== t(f).MACHINE_PART.V ? (r(), u(l, { key: 4, prop: "length", "show-overflow-tooltip": true, label: "长度(mm)", width: "100px", align: "center" })) : h("", true), o(l, { prop: "numbersMap", "show-overflow-tooltip": true, label: "一物一码", "min-width": "130px", "header-align": "center" }, { default: i(({ row: { sourceRow: e } }) => [o(I, { modelValue: e.numbersMap, "onUpdate:modelValue": (n) => e.numbersMap = n, type: "other", options: e.numbersArr, dataStructure: { key: "id", label: "label", value: "id" }, "collapse-tags": "", multiple: "", clearable: "", "multiple-limit": e.canCollabQuantity, placeholder: "选择一物一码", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "multiple-limit"])]), _: 1 }), t(p).query.taskTypeEnum === t(f).MACHINE_PART.V ? (r(), u(l, { key: 5, align: "center", prop: "askCompleteTime", "show-overflow-tooltip": true, label: "计划完成日期", width: "120px" })) : h("", true), t(p).query.taskTypeEnum === t(f).MACHINE_PART.V ? (r(), u(l, { key: 6, prop: "group.name", "show-overflow-tooltip": true, label: "原生产组", "min-width": "180px" }, { default: i(({ row: e }) => {
      var n, b, v;
      return [_("span", null, w((n = e.workshop) == null ? void 0 : n.name) + ">" + w((b = e.productionLine) == null ? void 0 : b.name) + ">" + w((v = e.groups) == null ? void 0 : v.name), 1)];
    }), _: 1 })) : h("", true), o(l, { "show-overflow-tooltip": true, prop: "groupsId", label: "生产组", "min-width": "150px", align: "center" }, { default: i(({ row: { sourceRow: e }, $index: n }) => {
      var b;
      return [o(m, { modelValue: e.groupsId, "onUpdate:modelValue": (v) => e.groupsId = v, options: (b = V.value[e.configId]) == null ? void 0 : b.list, props: { value: "id", label: "name", children: "children", expandTrigger: "hover", emitPath: false }, "show-all-levels": "", filterable: "", clearable: "", placeholder: n === 0 ? "请选择生产组" : "同上", style: { width: "100%" }, onChange: (v) => ie(v, e, n) }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "placeholder", "onChange"])];
    }), _: 1 })]), _: 1 }, 8, ["data", "max-height", "cell-class-name", "data-format"])), [[C, L.value]])], 4), o(S, null, { default: i(() => a[7] || (a[7] = [_("span", { class: "title" }, "非一物一码", -1)])), _: 1, __: [7] }), _("div", { style: K(`height: ${t(q) / 2}px;`) }, [F((r(), u(x, { data: G.value, "max-height": t(q), "cell-class-name": t(be), "data-format": Y.value, onSelectionChange: ve, style: { width: "100%" } }, { default: i(() => [o(l, { type: "selection", width: "55", align: "center", selectable: _e }), o(l, { label: "序号", type: "index", align: "center", width: "60" }), t(p).query.taskTypeEnum !== t(f).MACHINE_PART.V ? (r(), u(l, { key: 0, prop: "area.name", "show-overflow-tooltip": true, label: "区域", "min-width": "100px", align: "center" })) : h("", true), t(p).query.taskTypeEnum === t(f).MACHINE_PART.V ? (r(), u(l, { key: 1, prop: "cutNumber", "show-overflow-tooltip": true, label: "切割指令号", "min-width": "100px", align: "center" })) : h("", true), t(p).query.taskTypeEnum === t(f).ASSEMBLE.V ? (r(), u(l, { key: 2, prop: "attributeType", "show-overflow-tooltip": true, label: "属性", width: "90", align: "center" }, { default: i(({ row: e }) => [o(c, { type: e.attributeType === "部件" ? "warning" : "success" }, { default: i(() => [M(w(e.attributeType), 1)]), _: 2 }, 1032, ["type"])]), _: 1 })) : h("", true), t(p).query.taskTypeEnum !== t(f).MACHINE_PART.V ? (r(), u(l, { key: 3, prop: "serialNumber", "show-overflow-tooltip": true, label: "编号", "min-width": "100px", align: "center" })) : h("", true), o(l, { prop: "specification", "show-overflow-tooltip": true, label: "规格", "min-width": "100px", align: "center" }), o(l, { prop: "totalNetWeight", "show-overflow-tooltip": true, label: "总净重", align: "center" }), o(l, { prop: "totalGrossWeight", "show-overflow-tooltip": true, label: "总毛重", align: "center" }), t(p).query.taskTypeEnum !== t(f).MACHINE_PART.V ? (r(), u(l, { key: 4, prop: "length", "show-overflow-tooltip": true, label: "长度(mm)", width: "100px", align: "center" })) : h("", true), o(l, { prop: "maxQuantity", "show-overflow-tooltip": true, label: "协同数量", "min-width": "100px", align: "center" }, { default: i(({ row: { sourceRow: e } }) => [o(B, { modelValue: e.maxQuantity, "onUpdate:modelValue": (n) => e.maxQuantity = n, step: 1, min: 1, max: e.quantity, precision: 0, size: "default", "controls-position": "right", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "max"])]), _: 1 }), t(p).query.taskTypeEnum === t(f).MACHINE_PART.V ? (r(), u(l, { key: 5, align: "center", prop: "askCompleteTime", "show-overflow-tooltip": true, label: "计划完成日期", width: "120px" })) : h("", true), t(p).query.taskTypeEnum === t(f).MACHINE_PART.V ? (r(), u(l, { key: 6, prop: "group.name", "show-overflow-tooltip": true, label: "原生产组", "min-width": "180px" }, { default: i(({ row: e }) => {
      var n, b, v;
      return [_("span", null, w((n = e.workshop) == null ? void 0 : n.name) + ">" + w((b = e.productionLine) == null ? void 0 : b.name) + ">" + w((v = e.groups) == null ? void 0 : v.name), 1)];
    }), _: 1 })) : h("", true), o(l, { "show-overflow-tooltip": true, prop: "groupsId", label: "生产组", "min-width": "150px", align: "center" }, { default: i(({ row: { sourceRow: e }, $index: n }) => {
      var b;
      return [o(m, { modelValue: e.groupsId, "onUpdate:modelValue": (v) => e.groupsId = v, options: (b = V.value[e.configId]) == null ? void 0 : b.list, props: { value: "id", label: "name", children: "children", expandTrigger: "hover", emitPath: false }, "show-all-levels": "", filterable: "", clearable: "", placeholder: n === 0 ? "请选择生产组" : "同上", style: { width: "100%" }, onChange: (v) => ie(v, e, n) }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "placeholder", "onChange"])];
    }), _: 1 })]), _: 1 }, 8, ["data", "max-height", "cell-class-name", "data-format"])), [[C, L.value]])], 4)], 4), o(t(Se), { visible: O.value, "onUpdate:visible": a[2] || (a[2] = (e) => O.value = e), info: N.info, list: H.value, onSuccess: Te }, null, 8, ["visible", "info", "list"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, Ke = He(Qe, [["__scopeId", "data-v-e6b78a4d"]]);
export {
  Ke as default
};
