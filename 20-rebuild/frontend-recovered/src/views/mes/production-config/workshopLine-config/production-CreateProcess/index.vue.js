import { ref as c } from "vue";
import { computed as j } from "vue";
import { watch as qe } from "vue";
import { resolveComponent as F } from "vue";
import { openBlock as o } from "vue";
import { createElementBlock as h } from "vue";
import { createElementVNode as d } from "vue";
import { createVNode as _ } from "vue";
import { unref as s } from "vue";
import { withDirectives as Ve } from "vue";
import { createBlock as w } from "vue";
import { withCtx as m } from "vue";
import { toDisplayString as I } from "vue";
import { Fragment as $ } from "vue";
import { createCommentVNode as A } from "vue";
import { createTextVNode as q } from "vue";
import { renderList as se } from "vue";
import { normalizeClass as le } from "vue";
import { ElMessage as z } from "element-plus";
import { ElCascader as Le } from "element-plus";
import { ElTableColumn as xe } from "element-plus";
import { Plus as Ce } from "@element-plus/icons-vue";
import { ElTooltip as Ee } from "element-plus";
import { ElIcon as Se } from "element-plus";
import { Close as Ne } from "@element-plus/icons-vue";
import { vLoading as Re } from "element-plus";
import { c as oe, a as Fe, g as $e, b as De, d as Oe, e as Me, f as Ue, h as Be } from "../../../../../modules/product-process-55b57b27.js";
import { _ as je, aU as ze, dM as g, x as He, p2 as We, o as Je, er as Ke, a3 as Qe, es as Ge, P as Xe, i as k, cf as Ye, V as H } from "../../../../../shared/runtime.js";
import { u as Ze } from "../../../../../modules/use-process-af1f8c99.js";
import et from "./module/header.vue.js";
import "../../../../../modules/mes-bridge-enum-radio-5a510e87.js";
const tt = { class: "app-container" }, at = { style: { display: "flex", "margin-top": "10px" } }, st = { style: { flex: "1" } }, lt = { class: "head-container flex" }, ot = { key: 0 }, nt = { key: 1 }, rt = { key: 1 }, ut = { style: { width: "50%" } }, it = { style: { padding: "0", "box-sizing": "border-box" } }, ct = { key: 0, class: "my-code", style: { "border-left": "0 none" } }, dt = { key: 1 }, pt = { class: "my-code", style: { "border-left": "0 none" } }, ft = { style: { float: "right" } }, mt = { class: "line-wrap" }, yt = { class: "bg-div" }, vt = { key: 1, class: "val-item" }, ht = { key: 1, class: "val-item" }, _t = { class: "icon-div" }, gt = { __name: "index", setup(bt) {
  const { process: W } = Ze(), ne = { add: false, edit: false, del: false, download: false }, re = c([["productionLineTypeEnum", ["parse-enum", ze]]]), x = c([]), D = c(), b = c(), O = c(), P = c({}), r = c([]), M = c([]), C = c(false), ue = j(() => a.query.type === g.MACHINE_PART.V ? 1 : 2), ie = j(() => ({ value: "id", label: "name", children: "children", expandTrigger: "hover", checkStrictly: true })), J = c(), E = c(false), U = c(false), v = c(false), S = c([]), N = c({}), K = c([]), Q = c([]), R = c([]), G = c(), { crud: a, CRUD: X, columns: Y } = He({ title: "创建工序", sort: [], permission: { ...We }, optShow: { ...ne }, crudApi: { ...oe }, hasPagination: true }, J), Z = j(() => x.value.filter((t) => t.productType === a.query.type) || []), { maxHeight: ce } = Je({ wrapperBox: ".head-container", paginate: true, extraHeight: 80 });
  qe([() => a.query.type, () => a.query.mesProductEnum], () => {
    b.value = void 0, D.value = void 0, pe(a.query.mesProductEnum, a.query.type);
  }), X.HOOK.beforeToQuery = () => {
    P.value = {}, r.value = [], M.value = [];
  }, X.HOOK.beforeRefresh = () => {
    a.crudApi.get = a.query.type & g.ASSEMBLE.V ? Fe : a.query.type & g.ARTIFACT.V ? $e : De;
  };
  function de(t) {
    let e = [];
    return k(W.value) && (e = W.value.filter((u) => u.type === Ye.PAINT.V && a.query.type === g.ARTIFACT.V)), t === 0 ? e.map((u) => u.id) || [] : [];
  }
  async function pe(t, e) {
    var p;
    x.value = [];
    const u = [];
    try {
      (p = (await Ke({ workShopType: t })).content) == null || p.map((y) => {
        y.disabled = true, y.workshopList.map((T) => {
          T.disabled = true, e ? T.children = T.productionLineList.filter((V) => V.productType === e) || [] : T.children = T.productionLineList.filter((V) => V.productType === Qe.ARTIFACT.V) || [], u.push(T);
        }), y.children = y.workshopList || [];
      }), x.value = u;
    } catch (f) {
      console.log("获取工厂车间生产线树失败", f);
    }
  }
  function fe(t) {
    P.value = t, B(), S.value && (v.value = false);
  }
  function me(t, e) {
    k(r.value[e + 1]) ? r.value[e + 1].push({ sequence: t[0].sequence + 1 }) : r.value[e + 1] = [{ sequence: t[0].sequence + 1 }];
  }
  function ye(t, e) {
    r.value[e].splice(t, 1), k(r.value[e]) || r.value.splice(e, 1);
  }
  async function B() {
    var t;
    if (E.value = true, r.value = [], !(!P.value.id || !b.value)) try {
      const { content: e } = await Oe({ classId: P.value.id, lineId: b.value, taskTypeEnum: a.query.type, mesProductEnum: a.query.mesProductEnum });
      k(e) || (v.value = true);
      const u = {}, p = [];
      G.value = ((t = e == null ? void 0 : e[0]) == null ? void 0 : t.productProcessId) || null, e.map((f) => {
        k(u[f.sequence]) ? u[f.sequence].push(f) : u[f.sequence] = [f];
      });
      for (const f in u) p.push(u[f]);
      r.value = k(e) ? H(p) : H([[{ sequence: 0 }]]), M.value = JSON.parse(JSON.stringify(r.value)), E.value = false;
    } catch (e) {
      console.log("获取工序", e), E.value = false;
    }
  }
  async function ve() {
    if (S.value = [], N.value = {}, !!b.value) {
      Z.value.find((t) => t.id === b.value);
      try {
        const { content: t } = await Ue({ productionLineId: b.value, mesProductEnum: a.query.mesProductEnum });
        t == null || t.map((e) => {
          var u;
          (u = e.prodLineInfos) == null || u.map((p) => {
            p.label = e.processName;
          }), N.value[e.processId] = e.prodLineInfos[0].teamInfo;
        }), S.value = t.filter((e) => e.taskTypeEnum === a.query.type);
      } catch (t) {
        console.log("获取工序", t), E.value = false;
      }
    }
  }
  async function he() {
    try {
      const t = [];
      let e = true;
      if (r.value.forEach((f) => {
        k(f) && f.forEach((y) => {
          if (y.processId && y.teamId) t.push(y);
          else if (y.processId && !y.teamId) {
            e = false;
            return;
          }
        });
      }), !e) {
        z.error("班组不能为空");
        return;
      }
      const u = Z.value.find((f) => f.id === b.value) || {}, p = { classId: P.value.id, lineId: b.value, shopId: O.value, processLinkList: t, productType: a.query.type, mesProductEnum: a.query.mesProductEnum };
      await oe.edit(p), z.success("工序保存成功"), v.value = false, B(), U.value = false;
    } catch (t) {
      console.log("获取工序", t), U.value = false;
    }
  }
  async function _e() {
    try {
      const t = { lineId: b.value, taskTypeEnum: a.query.type, mesProductEnum: a.query.mesProductEnum }, { content: e } = await Be(t);
      K.value = e, Q.value = e.filter((u) => u.hasProcess);
    } catch (t) {
      console.log(t);
    }
  }
  async function ge() {
    try {
      const t = { productProcessId: G.value, taskTypeEnum: a.query.type, classIds: R.value, mesProductEnum: a.query.mesProductEnum };
      await Me(t), ee(), z({ message: "应用成功", type: "success" });
    } catch (t) {
      console.log(t);
    }
  }
  const ee = () => {
    C.value = false, R.value = [];
  };
  function be() {
    _e(), C.value = true;
  }
  function we() {
    r.value = H(M.value), Object.keys(r.value[0][0]).length > 1 && (v.value = false);
  }
  async function ke(t) {
    t && t.length ? (O.value = t[0], b.value = t[1]) : (O.value = void 0, b.value = void 0), v.value = false, await B(), await ve();
  }
  return (t, e) => {
    const u = Le, p = xe, f = F("common-table"), y = F("common-button"), T = F("common-select"), V = Ce, Te = Ee, te = Se, Ie = Ne, Pe = F("common-dialog"), Ae = Re;
    return o(), h("div", tt, [d("div", at, [d("div", st, [d("div", lt, [_(s(et)), _(u, { modelValue: D.value, "onUpdate:modelValue": e[0] || (e[0] = (l) => D.value = l), options: x.value, props: ie.value, filterable: "", clearable: "", "show-all-levels": "", placeholder: "请选择生产线", class: "filter-item cascader-style", style: { width: "250px" }, onChange: ke }, null, 8, ["modelValue", "options", "props"])]), Ve((o(), w(f, { ref_key: "tableRef", ref: J, stripe: false, data: s(a).data, "data-format": re.value, "empty-text": s(a).emptyText, "max-height": s(ce), "highlight-current-row": "", onRowClick: fe, style: { width: "100%" } }, { default: m(() => [_(p, { label: "序号", type: "index", align: "center", width: "60" }), _(p, { prop: "classificationName", align: "center", width: "100px", "show-overflow-tooltip": true, label: "类型名称" }, { default: m(({ row: { sourceRow: l } }) => [d("span", null, I(s(a).query.type === s(g).ARTIFACT.V ? l.classificationName : l.name), 1)]), _: 1 }), s(a).query.type === s(g).ARTIFACT.V && s(Y).visible("artifactType") ? (o(), w(p, { prop: "artifactType", align: "center", "show-overflow-tooltip": true, label: "类型", width: "90px", key: "artifactType" }, { default: m(({ row: { sourceRow: l } }) => [s(a).query.type === s(g).ARTIFACT.V ? (o(), h($, { key: 0 }, [l.artifactType ? (o(), h("span", ot, I(s(Ge).VL[l.artifactType]), 1)) : (o(), h("span", nt, "-"))], 64)) : (o(), h("span", rt, "-"))]), _: 1 })) : A("", true), s(a).query.type === s(g).ARTIFACT.V && s(Y).visible("specPrefixSequence") ? (o(), w(p, { prop: "specPrefixSequence", align: "left", "show-overflow-tooltip": true, label: "构件前缀", key: "specPrefixSequence" }, { default: m(({ row: l }) => {
      var n;
      return [d("span", null, I(((n = l.specPrefixList) == null ? void 0 : n.map((i) => `【${i.specPrefix}】`).join("")) || "-"), 1)];
    }), _: 1 })) : A("", true), s(a).query.type === s(g).ASSEMBLE.V ? (o(), w(p, { key: 2, prop: "specPrefixSequence", align: "left", "show-overflow-tooltip": true, label: "部件前缀", "min-width": "300" }, { default: m(({ row: l }) => {
      var n;
      return [d("span", null, I(((n = l.assembleSpecList) == null ? void 0 : n.map((i) => `【${i.specPrefix}】`).join("")) || "-"), 1)];
    }), _: 1 })) : A("", true), s(a).query.type === s(g).ARTIFACT.V ? (o(), w(p, { key: 3, prop: "prefixListArr", align: "left", "show-overflow-tooltip": true, label: "匹配名称" }, { default: m(({ row: l }) => {
      var n;
      return [d("span", null, I(((n = l.serialNumberPrefixList) == null ? void 0 : n.map((i) => `【${i.serialNumberPrefix}】`).join("")) || "-"), 1)];
    }), _: 1 })) : A("", true), s(a).query.type === s(g).MACHINE_PART.V ? (o(), w(p, { key: 4, prop: "specSequence", "show-overflow-tooltip": true, label: "规格前缀索引", "min-width": "300" }, { default: m(({ row: l }) => {
      var n;
      return [d("span", null, I(((n = l.links) == null ? void 0 : n.map((i) => `${i.keyword}【${i.specIndex ? i.specIndex : "全部"}】`).join("、")) || "-"), 1)];
    }), _: 1 })) : A("", true)]), _: 1 }, 8, ["data", "data-format", "empty-text", "max-height"])), [[Ae, s(a).loading]]), _(s(Xe))]), e[10] || (e[10] = d("div", { style: { "border-right": "1px solid #ededed", margin: "0 20px", height: "calc(100vh - 180px)" } }, null, -1)), d("div", ut, [e[9] || (e[9] = d("div", null, null, -1)), d("div", it, [!s(k)(P.value) || !b.value ? (o(), h("div", ct, "*点击左侧表格和产线行查看工序")) : (o(), h("div", dt, [d("div", pt, [q(" 当前" + I(s(g).VL[s(a).query.type]) + "类型：" + I(s(a).query.type === s(g).ARTIFACT.V ? P.value.classificationName : P.value.name) + " ", 1), d("div", ft, [v.value ? A("", true) : (o(), w(y, { key: 0, size: "default", type: "success", onClick: be }, { default: m(() => e[4] || (e[4] = [q("应用全部")])), _: 1, __: [4] })), v.value ? (o(), h($, { key: 2 }, [_(y, { size: "default", type: "info", onClick: we }, { default: m(() => e[6] || (e[6] = [q("取消")])), _: 1, __: [6] }), _(y, { type: "success", size: "default", onClick: he }, { default: m(() => e[7] || (e[7] = [q("保存")])), _: 1, __: [7] })], 64)) : (o(), w(y, { key: 1, size: "default", type: "warning", onClick: e[1] || (e[1] = (l) => v.value = true) }, { default: m(() => e[5] || (e[5] = [q("编辑")])), _: 1, __: [5] }))])]), (o(true), h($, null, se(r.value, (l, n) => (o(), h("div", { key: n, class: le(`parent-wrap ${l.length === 1 ? "center-parent-wrap" : ""} ${(l.length > 1 || s(k)(r.value[n + 1]) && r.value[n + 1].length > 1) && n !== r.value.length - 1 ? "" : "last-parent-wrap"}`) }, [(o(true), h($, null, se(l, (i, ae) => (o(), h("div", { key: ae, class: le(`div-wrap ${n === 0 ? "first-div-wrap" : ""} ${n === r.value.length - 1 ? "last-div-wrap" : ""}`) }, [d("div", mt, [d("div", yt, [v.value ? (o(), w(T, { key: 0, modelValue: i.processId, "onUpdate:modelValue": (L) => i.processId = L, options: S.value, type: "other", filterable: "", clearable: "", class: "input-border-none", dataStructure: { key: "processId", label: "processName", value: "processId" }, "disabled-value": de(n), placeholder: "请选择工序", style: { width: "220px" }, disabled: !v.value }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "disabled-value", "disabled"])) : (o(), h("span", vt, I(i.processName), 1))]), e[8] || (e[8] = d("div", { class: "line-div" }, null, -1)), v.value ? (o(), w(T, { key: 0, modelValue: i.teamId, "onUpdate:modelValue": (L) => i.teamId = L, options: i.processId && N.value[i.processId] ? N.value[i.processId] : [], type: "other", filterable: "", clearable: "", class: "input-border-none", dataStructure: { key: "id", label: "name", value: "id" }, placeholder: "请选择班组", style: { width: "220px" }, disabled: !v.value }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "disabled"])) : (o(), h("span", ht, I(i.teamLeaderName), 1))]), d("div", _t, [(s(k)(r.value[n + 1]) && r.value[n + 1].length < ue.value || !s(k)(r.value[n + 1])) && v.value ? (o(), w(te, { key: 0, onClick: (L) => me(l, n) }, { default: m(() => [_(Te, { effect: "light", content: "添加工序", placement: "top" }, { default: m(() => [_(V)]), _: 1 })]), _: 2 }, 1032, ["onClick"])) : A("", true), n !== 0 && v.value ? (o(), w(te, { key: 1, style: { "margin-left": "10px" }, onClick: (L) => ye(ae, n) }, { default: m(() => [_(Ie)]), _: 2 }, 1032, ["onClick"])) : A("", true)])], 2))), 128))], 2))), 128))]))])])]), _(Pe, { title: "请选择构件类型", modelValue: C.value, "onUpdate:modelValue": e[3] || (e[3] = (l) => C.value = l), "before-close": ee, width: "500px", "show-close": true, "close-on-click-modal": false, "custom-class": "excel-resolve-preview", top: "10vh" }, { titleRight: m(() => [_(y, { loading: U.value, type: "success", size: "default", onClick: ge }, { default: m(() => e[11] || (e[11] = [q("提 交")])), _: 1, __: [11] }, 8, ["loading"])]), default: m(() => [_(T, { modelValue: R.value, "onUpdate:modelValue": e[2] || (e[2] = (l) => R.value = l), options: K.value, type: "other", filterable: "", clearable: "", multiple: "", dataStructure: { key: "id", label: "className", value: "id" }, placeholder: "请选择构件类型", style: { width: "100%" }, disabledVal: Q.value.map((l) => l.id) }, null, 8, ["modelValue", "options", "disabledVal"])]), _: 1 }, 8, ["modelValue"])]);
  };
} }, qt = je(gt, [["__scopeId", "data-v-c3fea7c5"]]);
export {
  qt as default
};
