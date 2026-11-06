import { ref as I } from "vue";
import { resolveComponent as H } from "vue";
import { openBlock as d } from "vue";
import { createBlock as g } from "vue";
import { withCtx as l } from "vue";
import { createElementVNode as e } from "vue";
import { withModifiers as L } from "vue";
import { createVNode as a } from "vue";
import { toDisplayString as c } from "vue";
import { unref as u } from "vue";
import { createElementBlock as r } from "vue";
import { Fragment as k } from "vue";
import { renderList as w } from "vue";
import { createCommentVNode as M } from "vue";
import { ElCol as P } from "element-plus";
import { ElRow as F } from "element-plus";
import { ElTooltip as O } from "element-plus";
import { ElImage as Q } from "element-plus";
import { _ as Y, u as $, g8 as G, n_ as J, p as x, u6 as K, a as W } from "../../../../../shared/runtime.js";
import { i as X, f as Z } from "../../../../../modules/roster-manage-12e649bc.js";
import ee from "./qr-code-dlg.vue.js";
import "../../../../../modules/index-c549a8fd.js";
import "../../../../../modules/html2canvas.esm-e0a7d97b.js";
const te = { class: "item" }, se = { class: "item-content" }, ie = { class: "item" }, le = { class: "item-content" }, ae = { class: "item" }, oe = { class: "item-content" }, ne = { class: "item" }, de = { class: "item-content" }, ce = { class: "item" }, _e = { class: "item-content" }, re = { class: "item" }, me = { class: "item-content ellipsis-text" }, ue = { class: "img" }, ve = { key: 1, style: { width: "100%", "text-align": "center", color: "#606266" } }, pe = { class: "grop" }, fe = { class: "item" }, he = { class: "item-content" }, ye = { class: "item" }, be = { class: "item-content" }, ge = { class: "item" }, ke = { class: "item-content" }, we = { class: "item" }, xe = { class: "item-content" }, Ne = { class: "grop" }, Ce = { key: 0 }, Ee = { class: "item" }, Ae = { class: "item-content" }, Ie = { class: "item" }, Ve = { class: "item-content" }, Be = { class: "grop" }, De = { class: "item", style: { height: "152px" } }, Te = { class: "item-content", style: { overflow: "auto" } }, Ue = { key: 0, class: "file-list" }, Re = { style: { "margin-left": "6px" } }, je = ["href"], Se = { style: { color: "#409eff !important" } }, qe = { key: 1 }, ze = { class: "item", style: { height: "152px" } }, He = { class: "item-content", style: { overflow: "auto" } }, Le = { key: 0, class: "file-list" }, Me = { style: { "margin-left": "6px" } }, Pe = ["href"], Fe = { style: { color: "#409eff !important" } }, Oe = { key: 1 }, Qe = { __name: "personal-info", props: { visible: { type: Boolean, default: false }, currentRow: { type: Object, default: () => {
} } }, emits: ["update:visible"], setup(V, { emit: B }) {
  const D = B, N = V, { visible: T, handleClose: U } = $({ emit: D, props: N, field: "visible", showHook: q }), h = I(false), i = I(), C = G(["site_work_type", "site_cert_type"]);
  async function R() {
    var v;
    try {
      i.value = await X({ id: N.currentRow.id }), S((v = i.value) == null ? void 0 : v.phone);
    } catch (s) {
      console.log(s);
    }
  }
  function j() {
    h.value = true;
  }
  async function S(v) {
    try {
      const { dept: s, job: p, roles: o, id: m } = await Z({ phone: v });
      if (i.value.deptName = (s == null ? void 0 : s.name) || void 0, i.value.jobName = (p == null ? void 0 : p.name) || void 0, i.value.userId = m || void 0, (o == null ? void 0 : o.length) > 0) {
        const y = o.map((b) => b.name) || [];
        i.value.roleNames = y.join();
      }
    } catch (s) {
      i.value.deptName = void 0, i.value.jobName = void 0, i.value.roleNames = void 0, i.value.roleIds = [], console.log(s);
    }
  }
  function q() {
    R();
  }
  return (v, s) => {
    const p = W, o = P, m = F, y = O, b = Q, z = H("common-drawer");
    return d(), g(z, { "append-to-body": "", title: "人员信息详情", visible: u(T), "before-close": u(U), "close-on-click-modal": false, size: "40%" }, { titleAfter: l(() => [e("span", { class: "pointer", onClick: L(j, ["stop"]) }, [a(p, { style: { "font-size": "25px" }, "icon-class": "qr-code" })])]), content: l(() => {
      var E, A;
      return [a(m, { class: "grop" }, { default: l(() => [a(o, { span: 20 }, { default: l(() => [a(m, null, { default: l(() => [a(o, { span: 12 }, { default: l(() => {
        var t;
        return [e("div", te, [s[1] || (s[1] = e("div", { class: "item-label" }, "姓名:", -1)), e("div", se, c(((t = i.value) == null ? void 0 : t.name) || "-"), 1)])];
      }), _: 1 }), a(o, { span: 12 }, { default: l(() => {
        var t;
        return [e("div", ie, [s[2] || (s[2] = e("div", { class: "item-label" }, "身份证号:", -1)), e("div", le, c(((t = i.value) == null ? void 0 : t.idNumber) || "-"), 1)])];
      }), _: 1 })]), _: 1 }), a(m, null, { default: l(() => [a(o, { span: 12 }, { default: l(() => {
        var t;
        return [e("div", ae, [s[3] || (s[3] = e("div", { class: "item-label" }, "性别:", -1)), e("div", oe, c(u(J).VL[(t = i.value) == null ? void 0 : t.sex] || "-"), 1)])];
      }), _: 1 }), a(o, { span: 12 }, { default: l(() => {
        var t;
        return [e("div", ne, [s[4] || (s[4] = e("div", { class: "item-label" }, "出生日期:", -1)), e("div", de, c(u(x)((t = i.value) == null ? void 0 : t.birthDate, "{y}-{m}-{d}")), 1)])];
      }), _: 1 })]), _: 1 }), a(m, null, { default: l(() => [a(o, { span: 12 }, { default: l(() => {
        var t;
        return [e("div", ce, [s[5] || (s[5] = e("div", { class: "item-label" }, "民族:", -1)), e("div", _e, c(((t = i.value) == null ? void 0 : t.nation) || "-"), 1)])];
      }), _: 1 }), a(o, { span: 12 }, { default: l(() => {
        var t;
        return [e("div", re, [s[6] || (s[6] = e("div", { class: "item-label" }, "家庭住址:", -1)), a(y, { class: "box-item", effect: "dark", content: (t = i.value) == null ? void 0 : t.homeAddress, placement: "top" }, { default: l(() => {
          var _;
          return [e("div", me, c(((_ = i.value) == null ? void 0 : _.homeAddress) || "-"), 1)];
        }), _: 1 }, 8, ["content"])])];
      }), _: 1 })]), _: 1 })]), _: 1 }), a(o, { span: 4 }, { default: l(() => {
        var t, _;
        return [e("div", ue, [(t = i.value) != null && t.avatarAttachment ? (d(), g(b, { key: 0, fit: "contain", style: { width: "100%", height: "100%" }, src: (_ = i.value) == null ? void 0 : _.avatarAttachment.imageUrl }, null, 8, ["src"])) : (d(), r("span", ve, "未上传图片"))])];
      }), _: 1 })]), _: 1 }), e("div", pe, [a(m, null, { default: l(() => [a(o, { span: 12 }, { default: l(() => {
        var t;
        return [e("div", fe, [s[7] || (s[7] = e("div", { class: "item-label" }, "入职日期:", -1)), e("div", he, c(u(x)((t = i.value) == null ? void 0 : t.entryDate, "{y}-{m}-{d}")), 1)])];
      }), _: 1 }), a(o, { span: 12 }, { default: l(() => {
        var t;
        return [e("div", ye, [s[8] || (s[8] = e("div", { class: "item-label" }, "工种:", -1)), e("div", be, c(u(C).label.site_work_type[(t = i.value) == null ? void 0 : t.workType] || "-"), 1)])];
      }), _: 1 })]), _: 1 }), a(m, null, { default: l(() => [a(o, { span: 12 }, { default: l(() => {
        var t;
        return [e("div", ge, [s[9] || (s[9] = e("div", { class: "item-label" }, "雇主单位:", -1)), e("div", ke, c(((t = i.value) == null ? void 0 : t.supplierName) || "-"), 1)])];
      }), _: 1 }), a(o, { span: 12 }, { default: l(() => {
        var t;
        return [e("div", we, [s[10] || (s[10] = e("div", { class: "item-label" }, "手机号:", -1)), e("div", xe, c(((t = i.value) == null ? void 0 : t.phone) || "-"), 1)])];
      }), _: 1 })]), _: 1 })]), e("div", Ne, [((E = i.value) == null ? void 0 : E.boolCert) === u(K).YES.V ? (d(), r("div", Ce, [(d(true), r(k, null, w((A = i.value) == null ? void 0 : A.certs, (t, _) => (d(), g(m, { key: _ }, { default: l(() => [a(o, { span: 12 }, { default: l(() => [e("div", Ee, [s[11] || (s[11] = e("div", { class: "item-label" }, "证书类型:", -1)), e("div", Ae, c(u(C).label.site_cert_type[t.certType] || "-"), 1)])]), _: 2 }, 1024), a(o, { span: 12 }, { default: l(() => [e("div", Ie, [s[12] || (s[12] = e("div", { class: "item-label" }, "到期时间:", -1)), e("div", Ve, c(u(x)(t.expirationTime, "{y}-{m}-{d}")), 1)])]), _: 2 }, 1024)]), _: 2 }, 1024))), 128))])) : M("", true)]), e("div", Be, [a(m, null, { default: l(() => [a(o, { span: 12 }, { default: l(() => {
        var t, _, f;
        return [e("div", De, [s[13] || (s[13] = e("div", { class: "item-label" }, "证书:", -1)), e("div", Te, [(_ = (t = i.value) == null ? void 0 : t.certAttachments) != null && _.length ? (d(), r("div", Ue, [(d(true), r(k, null, w((f = i.value) == null ? void 0 : f.certAttachments, (n) => (d(), r("div", { key: n.id, style: { width: "100%", "margin-bottom": "10px" } }, [e("div", Re, [e("a", { href: n == null ? void 0 : n.imageUrl, target: "_blank" }, [e("span", Se, c(n == null ? void 0 : n.name), 1)], 8, je)])]))), 128))])) : (d(), r("div", qe, "-"))])])];
      }), _: 1 }), a(o, { span: 12 }, { default: l(() => {
        var t, _, f;
        return [e("div", ze, [s[14] || (s[14] = e("div", { class: "item-label" }, "体检报告:", -1)), e("div", He, [(_ = (t = i.value) == null ? void 0 : t.physicalExaminationAttachment) != null && _.length ? (d(), r("div", Le, [(d(true), r(k, null, w((f = i.value) == null ? void 0 : f.physicalExaminationAttachment, (n) => (d(), r("div", { key: n.id, style: { width: "100%", "margin-bottom": "10px" } }, [e("div", Me, [e("a", { href: n == null ? void 0 : n.imageUrl, target: "_blank" }, [e("span", Fe, c(n == null ? void 0 : n.name), 1)], 8, Pe)])]))), 128))])) : (d(), r("div", Oe, "-"))])])];
      }), _: 1 })]), _: 1 })]), a(u(ee), { visible: h.value, "onUpdate:visible": s[0] || (s[0] = (t) => h.value = t), data: i.value }, null, 8, ["visible", "data"])];
    }), _: 1 }, 8, ["visible", "before-close"]);
  };
} }, Xe = Y(Qe, [["__scopeId", "data-v-6ee5a81d"]]);
export {
  Xe as default
};
