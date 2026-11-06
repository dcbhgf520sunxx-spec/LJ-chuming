import { ref as u } from "vue";
import { computed as ye } from "vue";
import { provide as _e } from "vue";
import { resolveComponent as Q } from "vue";
import { openBlock as d } from "vue";
import { createElementBlock as be } from "vue";
import { createElementVNode as m } from "vue";
import { unref as c } from "vue";
import { createBlock as v } from "vue";
import { withCtx as a } from "vue";
import { createTextVNode as _ } from "vue";
import { withModifiers as r } from "vue";
import { createCommentVNode as b } from "vue";
import { withDirectives as j } from "vue";
import { createVNode as n } from "vue";
import { normalizeStyle as he } from "vue";
import { toDisplayString as O } from "vue";
import { ElMessage as W } from "element-plus";
import { ElMessageBox as J } from "element-plus";
import { ElNotification as K } from "element-plus";
import { ElTableColumn as we } from "element-plus";
import { ElSwitch as Ce } from "element-plus";
import { ElPopover as Ee } from "element-plus";
import { ElDivider as ke } from "element-plus";
import { MapLocation as xe } from "@element-plus/icons-vue";
import { ElIcon as Le } from "element-plus";
import { vLoading as Ve } from "element-plus";
import { _ as Se, aS as g, mN as $e, G as f, p as X, a as Te } from "../../../../../shared/runtime.js";
import { g as Ue, a as Ne, b as Pe, d as Re, c as De, e as Be, f as ze } from "../../../../../modules/inspection-config-a69d9e2f.js";
import Ie from "./module/inspection-point-dlg.vue.js";
import Ae from "./module/user-line-dlg.vue.js";
import qe from "./module/qr-code-dlg.vue.js";
import Fe from "./module/personal-map-history.vue.js";
import He from "./module/audit-detail.vue.js";
import "../../../../../modules/index-df3c71c0.js";
import "../../../../../modules/inspection-manage-c10227da.js";
import "../../../../../modules/PicUpload-8580ccfc.js";
import "../../../../../modules/index-c549a8fd.js";
import "../../../../../modules/html2canvas.esm-e0a7d97b.js";
const Me = { class: "wrap" }, Ge = { class: "wrap-left" }, Qe = ["onClick"], je = { style: { "text-align": "right", margin: "0" } }, Oe = { class: "wrap-right" }, We = { style: { "text-align": "right", margin: "0" } }, Je = { __name: "index", props: { maxHeight: { type: Number, default: 500 }, permission: { type: Object, default: () => {
} }, point: { type: String, default: "" } }, emits: ["change-line-status", "user-change"], setup(p, { emit: Y }) {
  const x = Y, L = p, y = u([]), V = u(false), w = u([]), S = u(false), C = u(false), $ = u(false), R = u({}), E = u(false), T = u(false), D = u({}), U = u(false), B = u({}), N = u(false), z = u({}), I = u(false), Z = u(0), ee = ye(() => y.value.filter((e) => e.status === Number(g.TRUE.V)));
  _e("selectPointList", ee);
  const te = u([["avoidTime", ["parse-enum", $e, { f: "L", bit: true, split: "、" }]]]);
  k(), h(), P();
  async function k() {
    if (y.value = [], !!f(L.permission.settingGet)) try {
      V.value = true;
      const e = await Ue();
      y.value = e || [], y.value.forEach((t) => {
        t.pop = false, t.originStatus = t.status;
      });
    } catch (e) {
      console.log(e);
    } finally {
      V.value = false;
    }
  }
  async function h() {
    var e;
    if (w.value = [], !!f(L.permission.settingGet)) try {
      S.value = true;
      const t = await Ne();
      w.value = t || [], (e = w.value) == null || e.forEach((o) => {
        var s;
        o.inspectionQuantity = (s = o.inspectionList) == null ? void 0 : s.length, o.avoidTime = o.avoidTime || 0, o.pop = false, o.originStatus = o.status, o.originMandatoryInspection = o.mandatoryInspection;
      });
    } catch (t) {
      console.log(t);
    } finally {
      S.value = false;
    }
  }
  function ie() {
    C.value = true, $.value = false;
  }
  function ne() {
    E.value = true, T.value = false;
  }
  function oe(e) {
    C.value = true, $.value = true, R.value = e;
  }
  function ae(e) {
    E.value = true, T.value = true, D.value = e;
  }
  function A(e) {
    e.pop = true;
  }
  function q(e) {
    e.pop = false;
  }
  function le() {
    x("user-change");
  }
  async function se(e) {
    try {
      await Re({ id: e.id }), W({ type: "success", message: "删除成功" }), k();
    } catch (t) {
      console.log("删除失败", t);
    }
  }
  async function ue(e) {
    try {
      await De({ id: e.id }), W({ type: "success", message: "删除成功" }), h(), P(), x("user-change");
    } catch (t) {
      console.log("删除失败", t);
    }
  }
  async function ce(e, t) {
    try {
      await J.confirm(`此操作将 ${e.name} 的状态改为 ${g.VL[!!t]}, 是否继续？`, "提示", { confirmButtonText: "确定", cancelButtonText: "取消", type: "warning" }), await Be({ id: e.id }), k(), h(), K({ title: `${e.name}的状态修改成功`, type: "success", duration: 3e3 });
    } catch (o) {
      console.log("启用失败", o), e.status = e.originStatus;
    }
  }
  async function re(e, t) {
    try {
      await J.confirm(`此操作将 ${e.userName} 负责的巡检路线的状态改为 ${g.VL[!!t]}, 是否继续？`, "提示", { confirmButtonText: "确定", cancelButtonText: "取消", type: "warning" }), await ze({ id: e.id }), h(), x("change-line-status"), K({ title: `${e.userName}负责的巡检路线的状态修改成功`, type: "success", duration: 3e3 });
    } catch (o) {
      console.log("启用失败", o), e.status = e.originStatus;
    }
  }
  function pe(e) {
    U.value = true, B.value = e;
  }
  function de(e) {
    N.value = true, z.value = e, console.log(e, "row");
  }
  async function P() {
    try {
      const e = await Pe();
      Z.value = e || 0;
    } catch (e) {
      console.log(e, "获取审核列表的数量失败");
    }
  }
  return (e, t) => {
    const o = Q("common-button"), s = we, me = Te, F = Ce, H = Ee, M = Q("common-table"), ve = ke, fe = xe, ge = Le, G = Ve;
    return d(), be("div", Me, [m("div", Ge, [c(f)(p.permission.settingEdit) ? (d(), v(o, { key: 0, type: "primary", icon: "el-icon-plus", style: { "margin-bottom": "15px" }, onClick: r(ie, ["stop"]) }, { default: a(() => t[5] || (t[5] = [_(" 创建巡检点 ")])), _: 1, __: [5] })) : b("", true), j((d(), v(M, { data: y.value, "max-height": p.maxHeight }, { default: a(() => [n(s, { label: "序号", type: "index", align: "center", width: "60" }), n(s, { "show-overflow-tooltip": "", label: "巡检点", prop: "name", align: "center" }), n(s, { "show-overflow-tooltip": "", label: "二维码", align: "center", width: "90" }, { default: a(({ row: { sourceRow: i } }) => [m("span", { class: "pointer", onClick: r((l) => pe(i), ["stop"]) }, [n(me, { style: { "font-size": "25px", color: "#1677ff" }, "icon-class": "qr-code" })], 8, Qe)]), _: 1 }), n(s, { align: "center", prop: "status", label: "状态", width: "80" }, { default: a(({ row: { sourceRow: i } }) => [n(F, { modelValue: i.status, "onUpdate:modelValue": (l) => i.status = l, "active-value": Number(c(g).TRUE.V), "inactive-value": Number(c(g).FALSE.V), class: "drawer-switch", onChange: (l) => ce(i, i.status) }, null, 8, ["modelValue", "onUpdate:modelValue", "active-value", "inactive-value", "onChange"])]), _: 1 }), n(s, { label: "操作", width: "130", align: "center" }, { default: a(({ row: { sourceRow: i } }) => [c(f)(p.permission.settingEdit) ? (d(), v(o, { key: 0, icon: "el-icon-edit", type: "primary", onClick: r((l) => oe(i), ["stop"]) }, null, 8, ["onClick"])) : b("", true), n(H, { visible: i.pop, "onUpdate:visible": (l) => i.pop = l, placement: "top", width: "180", trigger: "manual" }, { reference: a(() => [c(f)(p.permission.del) ? (d(), v(o, { key: 0, type: "danger", icon: "el-icon-delete", onClick: r((l) => A(i), ["stop"]) }, null, 8, ["onClick"])) : b("", true)]), default: a(() => [t[8] || (t[8] = m("p", null, "确定删除本条数据吗？", -1)), m("div", je, [n(o, { size: "default", onClick: r((l) => q(i), ["stop"]) }, { default: a(() => t[6] || (t[6] = [_(" 取消 ")])), _: 2, __: [6] }, 1032, ["onClick"]), n(o, { type: "primary", size: "default", onClick: r((l) => se(i), ["stop"]) }, { default: a(() => t[7] || (t[7] = [_(" 确定 ")])), _: 2, __: [7] }, 1032, ["onClick"])])]), _: 2, __: [8] }, 1032, ["visible", "onUpdate:visible"])]), _: 1 })]), _: 1 }, 8, ["data", "max-height"])), [[G, V.value]])]), n(ve, { direction: "vertical", style: he(`height: ${p.maxHeight}px`) }, null, 8, ["style"]), m("div", Oe, [c(f)(p.permission.settingEdit) ? (d(), v(o, { key: 0, type: "primary", icon: "el-icon-plus", style: { "margin-bottom": "15px" }, disabled: !y.value.length, onClick: r(ne, ["stop"]) }, { default: a(() => t[9] || (t[9] = [_(" 创建负责人及巡检路线 ")])), _: 1, __: [9] }, 8, ["disabled"])) : b("", true), j((d(), v(M, { data: w.value, "data-format": te.value, "max-height": p.maxHeight }, { default: a(() => [n(s, { label: "序号", type: "index", align: "center", width: "60" }), n(s, { "show-overflow-tooltip": "", label: "责任人", prop: "userName", align: "center" }), n(s, { "show-overflow-tooltip": "", label: "巡检点", prop: "inspectionQuantity", align: "center" }), n(s, { "show-overflow-tooltip": "", label: "巡检次数", prop: "patrolsTime", align: "center" }), n(s, { "show-overflow-tooltip": "", label: "巡检路线", prop: "patrolsTime", align: "center" }, { default: a(({ row: i }) => [n(ge, { onClick: r((l) => de(i), ["stop"]), size: 22, color: "#67C23A" }, { default: a(() => [n(fe)]), _: 2 }, 1032, ["onClick"])]), _: 1 }), n(s, { "show-overflow-tooltip": "", label: "开始~结束", align: "center" }, { default: a(({ row: { sourceRow: i } }) => [m("span", null, O(c(X)(i.startTime, "{h}:{i}")) + " ~ " + O(c(X)(i.endTime, "{h}:{i}")), 1)]), _: 1 }), n(s, { "show-overflow-tooltip": "", label: "避开周末", prop: "avoidTime", align: "center" }), n(s, { align: "center", prop: "status", label: "状态", width: "80" }, { default: a(({ row: { sourceRow: i } }) => [n(F, { modelValue: i.status, "onUpdate:modelValue": (l) => i.status = l, "active-value": c(g).TRUE.V, "inactive-value": c(g).FALSE.V, class: "drawer-switch", onChange: (l) => re(i, i.status) }, null, 8, ["modelValue", "onUpdate:modelValue", "active-value", "inactive-value", "onChange"])]), _: 1 }), n(s, { label: "操作", width: "130", align: "center" }, { default: a(({ row: { sourceRow: i } }) => [c(f)(p.permission.settingEdit) ? (d(), v(o, { key: 0, icon: "el-icon-edit", type: "primary", onClick: r((l) => ae(i), ["stop"]) }, null, 8, ["onClick"])) : b("", true), n(H, { visible: i.pop, "onUpdate:visible": (l) => i.pop = l, placement: "top", width: "180", trigger: "manual" }, { reference: a(() => [c(f)(p.permission.del) ? (d(), v(o, { key: 0, type: "danger", icon: "el-icon-delete", onClick: r((l) => A(i), ["stop"]) }, null, 8, ["onClick"])) : b("", true)]), default: a(() => [t[12] || (t[12] = m("p", null, "确定删除本条数据吗？", -1)), m("div", We, [n(o, { size: "default", onClick: r((l) => q(i), ["stop"]) }, { default: a(() => t[10] || (t[10] = [_(" 取消 ")])), _: 2, __: [10] }, 1032, ["onClick"]), n(o, { type: "primary", size: "default", onClick: r((l) => ue(i), ["stop"]) }, { default: a(() => t[11] || (t[11] = [_(" 确定 ")])), _: 2, __: [11] }, 1032, ["onClick"])])]), _: 2, __: [12] }, 1032, ["visible", "onUpdate:visible"])]), _: 1 })]), _: 1 }, 8, ["data", "data-format", "max-height"])), [[G, S.value]])]), n(c(Ie), { visible: C.value, "onUpdate:visible": t[0] || (t[0] = (i) => C.value = i), isEdit: $.value, data: R.value, point: L.point, onEditSuccess: k }, null, 8, ["visible", "isEdit", "data", "point"]), n(c(Ae), { visible: E.value, "onUpdate:visible": t[1] || (t[1] = (i) => E.value = i), isEdit: T.value, data: D.value, onEditSuccess: h, onAddSuccess: le }, null, 8, ["visible", "isEdit", "data"]), n(c(qe), { visible: U.value, "onUpdate:visible": t[2] || (t[2] = (i) => U.value = i), data: B.value }, null, 8, ["visible", "data"]), n(Fe, { visible: N.value, "onUpdate:visible": t[3] || (t[3] = (i) => N.value = i), "personal-row": z.value }, null, 8, ["visible", "personal-row"]), n(c(He), { visible: I.value, "onUpdate:visible": t[4] || (t[4] = (i) => I.value = i), permission: p.permission, onSuccess: P }, null, 8, ["visible", "permission"])]);
  };
} }, pt = Se(Je, [["__scopeId", "data-v-f46d00a2"]]);
export {
  pt as default
};
