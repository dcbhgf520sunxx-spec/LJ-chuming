import { ref as x } from "vue";
import { computed as W } from "vue";
import { resolveComponent as w } from "vue";
import { openBlock as b } from "vue";
import { createBlock as L } from "vue";
import { withCtx as i } from "vue";
import { createElementVNode as n } from "vue";
import { createVNode as r } from "vue";
import { createTextVNode as C } from "vue";
import { unref as m } from "vue";
import { createElementBlock as S } from "vue";
import { Fragment as X } from "vue";
import { renderList as Y } from "vue";
import { toDisplayString as N } from "vue";
import { createCommentVNode as O } from "vue";
import { withDirectives as Z } from "vue";
import { isRef as $ } from "vue";
import { ElMessageBox as ee } from "element-plus";
import { ElNotification as te } from "element-plus";
import { ElRadio as ae } from "element-plus";
import { ElRadioGroup as le } from "element-plus";
import { ElTableColumn as ie } from "element-plus";
import { InfoFilled as re } from "@element-plus/icons-vue";
import { ElIcon as oe } from "element-plus";
import { ElTooltip as ne } from "element-plus";
import { ElSwitch as se } from "element-plus";
import { vLoading as ue } from "element-plus";
import { g as me } from "../../../../../modules/assembly-template-config-631cc212.js";
import { w as ce } from "../../../../../modules/artifact-tree-bcd3b733.js";
import { _ as de, u as fe, tz as U, es as pe, aS as T, aw as be } from "../../../../../shared/runtime.js";
const Pe = { style: { float: "right" } }, _e = { class: "range-action" }, ge = { key: 0, class: "tips-style" }, xe = { key: 1, class: "tips-style" }, we = { style: { display: "inline-block" } }, Ne = { class: "board-item" }, ve = { class: "board-item" }, ye = { __name: "auto-combination", props: { visible: { type: Boolean, default: false }, inventoryId: { type: [String, Number], default: void 0 } }, emits: ["update:visible", "success"], setup(A, { emit: B }) {
  const k = B, E = A, f = x([]), v = x(false), P = x(false), c = x(), { visible: y, handleClose: V } = fe({ emit: k, props: E, field: "visible", showHook: I, closeHook: q }), R = W(() => f.value.filter((o) => o.applicationState));
  function I() {
    z();
  }
  async function z() {
    let o = [];
    v.value = true;
    try {
      let e = await me();
      e.length && (e = e.map((a) => {
        var p, l, s, _, g;
        return a.artifactPartNumberPrefixOptions = (p = a.artifactPartNumberPrefixList) == null ? void 0 : p.map((d) => ({ name: d })), a.webPartNumberPrefixListOptions = (l = a.webPartNumberPrefixList) == null ? void 0 : l.map((d) => ({ name: d })), a.sailPartNumberPrefixListOptions = (s = a.sailPartNumberPrefixList) == null ? void 0 : s.map((d) => ({ name: d })), a.webPartNumberPrefix = (_ = a.webPartNumberPrefixList) == null ? void 0 : _[0], a.sailPartNumberPrefix = (g = a.sailPartNumberPrefixList) == null ? void 0 : g[0], a.applicationState = true, a;
      })), o = e;
    } catch (e) {
      console.log(e);
    } finally {
      f.value = o, v.value = false;
    }
  }
  const D = { artifactPartNumberPrefixList: [{ validator: (o, e) => !(!e.artifactPartNumberPrefixList && e.applicationState), message: "请输入构件定义类型", trigger: "change" }], PartNumberPrefixList: [{ validator: (o, e) => !((!e.webPartNumberPrefix || !e.sailPartNumberPrefix) && e.applicationState), message: "请配置前缀默认翼腹板", trigger: "change" }] }, { tableValidate: M, wrongCellMask: F } = be({ rules: D });
  function H(o, e) {
    e && (o.artifactPartNumberPrefixOptions = e == null ? void 0 : e.map((a) => ({ name: a })));
  }
  function j() {
    const o = f.value.map((l) => (l.webPartNumberPrefixList = l.webPartNumberPrefix ? [l.webPartNumberPrefix] : [], l.sailPartNumberPrefixList = l.sailPartNumberPrefix ? [l.sailPartNumberPrefix] : [], l)), { validResult: e, dealList: a } = M(f.value);
    if (e) f.value = a;
    else return e;
    const p = { inventoryOperationId: E.inventoryId, rangeOfActionEnum: c.value, templatePanelAssemblyConfigVOS: o.filter((l) => l.applicationState) };
    ee.confirm("是否确认根据板拼配置自动组合部件？", { confirmButtonText: "确定", cancelButtonText: "取消", type: "warning", draggable: true }).then(async () => {
      P.value = true, await ce(p), te({ title: "自动组合成功！", type: "success", duration: 2500 }), V(), k("success");
    }).catch((l) => {
      console.log(l, "自动组合失败");
    }).finally(() => {
      P.value = false;
    });
  }
  function q() {
    c.value = void 0;
  }
  return (o, e) => {
    const a = w("common-button"), p = ae, l = le, s = ie, _ = re, g = oe, d = ne, h = w("common-select"), G = se, J = w("common-table"), K = w("common-dialog"), Q = ue;
    return b(), L(K, { "append-to-body": "", "close-on-click-modal": false, modelValue: m(y), "onUpdate:modelValue": e[1] || (e[1] = (t) => $(y) ? y.value = t : null), title: "自动组合", width: "85vw", "show-close": false, onClosed: m(V) }, { titleAfter: i(() => e[2] || (e[2] = [n("div", { class: "title-after" }, null, -1)])), titleRight: i(() => [n("span", Pe, [r(a, { loading: P.value, size: "default", type: "success", onClick: j, disabled: !c.value || !R.value.length }, { default: i(() => e[3] || (e[3] = [C(" 确 认 ")])), _: 1, __: [3] }, 8, ["loading", "disabled"]), r(a, { disabled: P.value, size: "default", onClick: m(V) }, { default: i(() => e[4] || (e[4] = [C("关 闭")])), _: 1, __: [4] }, 8, ["disabled", "onClick"])])]), default: i(() => [n("div", _e, [e[5] || (e[5] = n("span", { class: "title-after-label" }, "作用范围：", -1)), r(l, { modelValue: c.value, "onUpdate:modelValue": e[0] || (e[0] = (t) => c.value = t) }, { default: i(() => [(b(true), S(X, null, Y(m(U).ENUM, (t) => (b(), L(p, { key: t.V, value: t.V }, { default: i(() => [C(N(t.L), 1)]), _: 2 }, 1032, ["value"]))), 128))]), _: 1 }, 8, ["modelValue"]), c.value ? O("", true) : (b(), S("span", ge, "*请选择作用范围！")), c.value ? (b(), S("span", xe, " *通过配置零件" + N(m(U).V[c.value].tips) + "来判定清单构件类型(需全匹配),当腹板/翼板的编号前缀匹配清单后,自动组合 ", 1)) : O("", true)]), Z((b(), L(J, { ref: "tableRef", data: f.value, "empty-text": "暂无数据", "max-height": o.maxHeight, "return-source-data": "", "row-key": "id", "cell-class-name": m(F), style: { width: "100%" } }, { default: i(() => [r(s, { label: "序号", type: "index", align: "center", width: "60" }), r(s, { prop: "artifactType", label: "类型", align: "center", width: "200" }, { default: i((t) => [n("span", null, N(m(pe).VL[t.row.artifactType] || "-"), 1)]), _: 1 }), r(s, { prop: "structureClassificationName", label: "构件类型", align: "center", width: "200" }, { default: i((t) => [n("span", null, N(t.row.structureClassificationName), 1)]), _: 1 }), r(s, { prop: "artifactPartNumberPrefixList", label: "构件定义类型", align: "center", "min-width": "200px" }, { header: i(() => [r(d, { class: "item", effect: "light", content: "零件编号前缀/备注都具备时,自动默认为该构件类型,支持二次修改", placement: "top" }, { default: i(() => [n("div", we, [e[6] || (e[6] = n("span", null, "所属零件编号前缀/备注定义", -1)), r(g, null, { default: i(() => [r(_)]), _: 1 })])]), _: 1 })]), default: i((t) => [r(h, { ref: "artifactPartNumberPrefixRef", modelValue: t.row.artifactPartNumberPrefixList, "onUpdate:modelValue": (u) => t.row.artifactPartNumberPrefixList = u, options: t.row.artifactPartNumberPrefixOptions, type: "other", size: "default", class: "filter-item", dataStructure: { key: "name", label: "name", value: "name" }, placeholder: "请输入", "allow-create": "", filterable: "", multiple: "", clearable: "", style: { width: "350px" }, onChange: (u) => H(t.row, u) }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "onChange"])]), _: 1 }), r(s, { prop: "PartNumberPrefixList", label: "翼腹板识别属性配置", align: "center", "min-width": "200px" }, { default: i((t) => [n("div", Ne, [e[7] || (e[7] = n("span", { class: "board-label" }, "腹板：", -1)), r(h, { modelValue: t.row.webPartNumberPrefix, "onUpdate:modelValue": (u) => t.row.webPartNumberPrefix = u, options: t.row.webPartNumberPrefixListOptions, type: "other", size: "default", class: "filter-item", dataStructure: { key: "name", label: "name", value: "name" }, placeholder: "请输入", "allow-create": "", filterable: "", clearable: "", style: { width: "250px" } }, null, 8, ["modelValue", "onUpdate:modelValue", "options"])]), n("div", ve, [e[8] || (e[8] = n("span", { class: "board-label" }, "翼板：", -1)), r(h, { modelValue: t.row.sailPartNumberPrefix, "onUpdate:modelValue": (u) => t.row.sailPartNumberPrefix = u, options: t.row.sailPartNumberPrefixListOptions, type: "other", size: "default", class: "filter-item", dataStructure: { key: "name", label: "name", value: "name" }, placeholder: "请输入", "allow-create": "", filterable: "", clearable: "", style: { width: "250px" } }, null, 8, ["modelValue", "onUpdate:modelValue", "options"])])]), _: 1 }), r(s, { prop: "applicationState", label: "是否应用", align: "center" }, { default: i((t) => [r(G, { modelValue: t.row.applicationState, "onUpdate:modelValue": (u) => t.row.applicationState = u, "active-color": "#13ce66", "active-value": m(T).TRUE.V, "inactive-value": m(T).FALSE.V }, null, 8, ["modelValue", "onUpdate:modelValue", "active-value", "inactive-value"])]), _: 1 })]), _: 1 }, 8, ["data", "max-height", "cell-class-name"])), [[Q, v.value]])]), _: 1 }, 8, ["modelValue", "onClosed"]);
  };
} }, Oe = de(ye, [["__scopeId", "data-v-96c3ee5c"]]);
export {
  Oe as default
};
